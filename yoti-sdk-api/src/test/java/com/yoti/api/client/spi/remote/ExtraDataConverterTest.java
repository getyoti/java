package com.yoti.api.client.spi.remote;

import static com.yoti.api.client.spi.remote.proto.DataEntryProto.DataEntry.Type.THIRD_PARTY_ATTRIBUTE;
import static com.yoti.api.client.spi.remote.util.ProtoUtil.buildDataEntry;
import static com.yoti.api.client.spi.remote.util.ProtoUtil.buildDefinition;
import static com.yoti.api.client.spi.remote.util.ProtoUtil.buildExtraData;
import static com.yoti.api.client.spi.remote.util.ProtoUtil.buildIssuingAttributes;
import static com.yoti.api.client.spi.remote.util.ProtoUtil.buildThirdPartyAttribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import com.yoti.api.client.AttributeIssuanceDetails;
import com.yoti.api.client.ExtraData;
import com.yoti.api.client.ExtraDataException;
import com.yoti.api.client.spi.remote.proto.DataEntryProto;
import com.yoti.api.client.spi.remote.proto.ExtraDataProto;
import com.yoti.api.client.spi.remote.proto.IssuingAttributesProto;
import com.yoti.api.client.spi.remote.proto.ThirdPartyAttributeProto;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExtraDataConverterTest {

    private static final String SOME_DEFINITION_NAME = "com.thirdparty.id";
    private static final IssuingAttributesProto.Definition DEFINITION_PROTO = buildDefinition(SOME_DEFINITION_NAME);

    private static final String SOME_SECOND_DEFINITION_NAME = "com.thirdparty.other_id";
    private static final IssuingAttributesProto.Definition SECOND_DEFINITION_PROTO = buildDefinition(SOME_SECOND_DEFINITION_NAME);

    private static final String SOME_EXPIRY_DATE = "2019-10-15T22:04:05.123Z";
    private static final IssuingAttributesProto.IssuingAttributes ISSUING_ATTRIBUTES_PROTO = buildIssuingAttributes(SOME_EXPIRY_DATE, DEFINITION_PROTO, SECOND_DEFINITION_PROTO);

    private static final String THIRD_PARTY_ISSUANCE_TOKEN = "someIssuanceToken";
    private static final ThirdPartyAttributeProto.ThirdPartyAttribute THIRD_PARTY_ATTRIBUTE_PROTO =
            buildThirdPartyAttribute(THIRD_PARTY_ISSUANCE_TOKEN, ISSUING_ATTRIBUTES_PROTO);

    private static final ByteString THIRD_PARTY_ATTRIBUTE_BYTES = THIRD_PARTY_ATTRIBUTE_PROTO.toByteString();
    private static final DataEntryProto.DataEntry DATA_ENTRY_PROTO = buildDataEntry(THIRD_PARTY_ATTRIBUTE, THIRD_PARTY_ATTRIBUTE_BYTES);

    private static final byte[] EXTRA_DATA_PROTO = createExtraData(DATA_ENTRY_PROTO);

    @InjectMocks
    ExtraDataConverter extraDataConverter;

    @Mock
    DataEntryConverter dataEntryConverterMock;

    @BeforeClass
    public static void setUp() {

    }

    @Test
    public void newInstance_shouldReturnInstanceOfExtraDataConverter() {
        ExtraDataConverter extraDataConverterTest = ExtraDataConverter.newInstance();
        assertNotNull(extraDataConverterTest);
    }

    @Test
    public void shouldWrapInvalidProtocolBufferException() {
        try {
            extraDataConverter.read(new byte[]{1, 2, 3});
        } catch (ExtraDataException e) {
            assertTrue(e.getCause() instanceof InvalidProtocolBufferException);
            return;
        }
        fail("Expected an Exception");
    }

    @Test
    public void shouldReturnExtraDataWithEmptyListForNullParameter() throws Exception {
        ExtraData extraData = extraDataConverter.read(null);
        assertNotNull(extraData);
    }

    @Test
    public void shouldReturnNullForCredentialIssuanceDetailsForNullExtraData() throws Exception {
        ExtraData extraData = extraDataConverter.read(null);
        AttributeIssuanceDetails credentialIssuanceDetails = extraData.getAttributeIssuanceDetails();

        assertNull(credentialIssuanceDetails);
    }

    @Test
    public void shouldIgnoreDataEntriesThatFailedToParse() throws Exception {
        ExtraDataException extraDataException = new ExtraDataException("Failed to parse data entry", new InvalidProtocolBufferException("Some error"));
        when(dataEntryConverterMock.convertDataEntry(any(DataEntryProto.DataEntry.class))).thenThrow(extraDataException);

        ExtraData extraData = extraDataConverter.read(EXTRA_DATA_PROTO);
        AttributeIssuanceDetails attributeIssuanceDetails = extraData.getAttributeIssuanceDetails();

        assertNull(attributeIssuanceDetails);
    }

    @Test
    public void shouldReturnFirstMatchingThirdPartyAttribute() throws Exception {
        when(dataEntryConverterMock.convertDataEntry(any(DataEntryProto.DataEntry.class)))
                .thenReturn(new AttributeIssuanceDetails("someValue", null, null))
                .thenReturn(new AttributeIssuanceDetails("someOtherValue", null, null));

        byte[] extraDataBytes = createExtraData(
                buildDataEntry(THIRD_PARTY_ATTRIBUTE, ByteString.copyFromUtf8("someValue")),
                buildDataEntry(THIRD_PARTY_ATTRIBUTE, ByteString.copyFromUtf8("someOtherValue"))
        );

        ExtraData extraData = extraDataConverter.read(extraDataBytes);
        AttributeIssuanceDetails attributeIssuanceDetails = extraData.getAttributeIssuanceDetails();

        assertNotNull(attributeIssuanceDetails);
        assertEquals("someValue", attributeIssuanceDetails.getToken());
        assertNotEquals("someOtherToken", attributeIssuanceDetails.getToken());
    }

    @Test
    public void shouldReturnNullForAttributeIssuanceDetailsWhenThirdPartyAttributeTokenIsMissing() throws Exception {
        ThirdPartyAttributeProto.ThirdPartyAttribute thirdPartyAttribute = buildThirdPartyAttribute("", null);
        DataEntryProto.DataEntry dataEntry = buildDataEntry(THIRD_PARTY_ATTRIBUTE, thirdPartyAttribute.toByteString());
        byte[] extraDataBytes = buildExtraData(dataEntry).toByteArray();

        when(dataEntryConverterMock.convertDataEntry(eq(dataEntry))).thenThrow(new ExtraDataException("Error"));

        ExtraData extraData = extraDataConverter.read(extraDataBytes);
        AttributeIssuanceDetails attributeIssuanceDetails = extraData.getAttributeIssuanceDetails();

        assertNull(attributeIssuanceDetails);
    }

    private static byte[] createExtraData(DataEntryProto.DataEntry... dataEntries) {
        return ExtraDataProto.ExtraData.newBuilder()
                .addAllList(Arrays.asList(dataEntries))
                .build()
                .toByteArray();
    }

}

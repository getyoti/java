package com.yoti.docscan.demo.service;

import com.yoti.api.client.Media;
import com.yoti.api.client.docs.DocScanClient;
import com.yoti.api.client.docs.DocScanException;
import com.yoti.api.client.docs.session.create.CreateSessionResult;
import com.yoti.api.client.docs.session.create.filters.DocumentFilterBuilderFactory;
import com.yoti.api.client.docs.session.create.filters.RequiredDocumentBuilderFactory;
import com.yoti.api.client.docs.session.create.objective.ObjectiveBuilderFactory;
import com.yoti.api.client.docs.session.create.SdkConfig;
import com.yoti.api.client.docs.session.create.SdkConfigBuilderFactory;
import com.yoti.api.client.docs.session.create.SessionSpec;
import com.yoti.api.client.docs.session.create.SessionSpecBuilderFactory;
import com.yoti.api.client.docs.session.create.check.RequestedCheckBuilderFactory;
import com.yoti.api.client.docs.session.create.task.RequestedTaskBuilderFactory;
import com.yoti.api.client.docs.session.retrieve.GetSessionResult;
import com.yoti.api.client.spi.remote.call.YotiConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DocScanService {

    private static final SdkConfigBuilderFactory SDK_CONFIG_BUILDER_FACTORY = SdkConfigBuilderFactory.newInstance();
    private static final SessionSpecBuilderFactory SESSION_SPEC_BUILDER_FACTORY = SessionSpecBuilderFactory.newInstance();
    private static final RequestedCheckBuilderFactory REQUESTED_CHECK_BUILDER_FACTORY = RequestedCheckBuilderFactory.newInstance();
    private static final RequestedTaskBuilderFactory REQUESTED_TASK_BUILDER_FACTORY = RequestedTaskBuilderFactory.newInstance();
    private static final RequiredDocumentBuilderFactory REQUIRED_DOCUMENT_FACTORY = RequiredDocumentBuilderFactory.newInstance();
    private static final DocumentFilterBuilderFactory ORTHOGONAL_FILTER_FACTORY = DocumentFilterBuilderFactory.newInstance();
    private static final ObjectiveBuilderFactory OBJECTIVE_BUILDER_FACTORY = ObjectiveBuilderFactory.newInstance();

    private static final String IFRAME_URL_FORMAT = "%s/web/index.html?sessionID=%s&sessionToken=%s";

    private final DocScanClient docScanClient;

    @Autowired
    public DocScanService(DocScanClient docScanClient) {
        this.docScanClient = docScanClient;
    }

    public CreateSessionResult createSession() throws DocScanException {
        SdkConfig sdkConfig = SDK_CONFIG_BUILDER_FACTORY.create()
                .withAllowsCameraAndUpload()
                .withPrimaryColour("#2d9fff")
                .withSecondaryColour("#FFFFFF")
                .withFontColour("#FFFFFF")
                .withLocale("en-GB")
                .withPresetIssuingCountry("GBR")
                .withSuccessUrl("https://localhost:8443/success")
                .withErrorUrl("https://localhost:8443/error")
                .withPrivacyPolicyUrl("https://localhost:8443/privacy-policy")
                .build();

        SessionSpec sessionSpec = SESSION_SPEC_BUILDER_FACTORY.create()
                .withClientSessionTokenTtl(600)
                .withResourcesTtl(90000)
                .withUserTrackingId("some-user-tracking-id")
                .withSdkConfig(sdkConfig)
                .withRequestedCheck(
                        REQUESTED_CHECK_BUILDER_FACTORY
                                .forDocumentAuthenticityCheck()
                                .build()
                )
                .withRequestedCheck(
                        REQUESTED_CHECK_BUILDER_FACTORY
                                .forFaceMatchCheck()
                                .withManualCheckAlways()
                                .build()
                )
                .withRequestedCheck(
                        REQUESTED_CHECK_BUILDER_FACTORY
                                .forLivenessCheck()
                                .forZoomLiveness()
                                .withMaxRetries(1)
                                .build()
                )
                .withRequestedCheck(
                        REQUESTED_CHECK_BUILDER_FACTORY
                                .forIdDocumentComparisonCheck()
                                .build()
                )
                .withRequestedCheck(
                        REQUESTED_CHECK_BUILDER_FACTORY
                                .forThirdPartyIdentityCheck()
                                .build()
                )
                .withRequestedTask(
                        REQUESTED_TASK_BUILDER_FACTORY
                                .forTextExtractionTask()
                                .withManualCheckAlways()
                                .build()
                )
                .withRequestedTask(
                        REQUESTED_TASK_BUILDER_FACTORY
                                .forSupplementaryDocTextExtractionTask()
                                .withManualCheckAlways()
                                .build()
                )
                .withRequiredDocument(
                        REQUIRED_DOCUMENT_FACTORY
                                .forIdDocument()
                                .withFilter(
                                        ORTHOGONAL_FILTER_FACTORY
                                                .forOrthogonalRestrictionsFilter()
                                                .withWhitelistedDocumentTypes(Arrays.asList("PASSPORT"))
                                                .build()
                                )
                                .build()
                )
                .withRequiredDocument(
                        REQUIRED_DOCUMENT_FACTORY
                                .forIdDocument()
                                .withFilter(
                                        ORTHOGONAL_FILTER_FACTORY
                                                .forOrthogonalRestrictionsFilter()
                                                .withWhitelistedDocumentTypes(Arrays.asList("DRIVING_LICENCE"))
                                                .build()
                                )
                                .build()
                )
                .withRequiredDocument(
                        REQUIRED_DOCUMENT_FACTORY
                                .forSupplementaryDocument()
                                .withObjective(
                                        OBJECTIVE_BUILDER_FACTORY
                                                .forProofOfAddress()
                                                .build()
                                )
                                .build()
                )
                .build();

        return docScanClient.createSession(sessionSpec);
    }

    public GetSessionResult getSession(String sessionId) throws DocScanException {
        return docScanClient.getSession(sessionId);
    }

    public String getIframeUrl(CreateSessionResult createSessionResult) {
        String apiUrl = System.getProperty(YotiConstants.PROPERTY_YOTI_DOCS_URL, YotiConstants.DEFAULT_YOTI_DOCS_URL);
        return String.format(IFRAME_URL_FORMAT, apiUrl, createSessionResult.getSessionId(), createSessionResult.getClientSessionToken());
    }

    public Media getMedia(String sessionId, String mediaId) throws DocScanException {
        return docScanClient.getMediaContent(sessionId, mediaId);
    }
}

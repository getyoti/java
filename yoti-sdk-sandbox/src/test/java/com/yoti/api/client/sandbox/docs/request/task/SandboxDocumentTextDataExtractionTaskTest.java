package com.yoti.api.client.sandbox.docs.request.task;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import com.yoti.api.client.sandbox.docs.request.SandboxDocumentFilter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SandboxDocumentTextDataExtractionTaskTest {

    private static final String SOME_KEY = "someKey";
    private static final String SOME_VALUE = "someValue";
    private static final Map<String, Object> SOME_DOCUMENT_FIELDS;

    static {
        SOME_DOCUMENT_FIELDS = new HashMap<>();
        SOME_DOCUMENT_FIELDS.put("firstKey", "firstValue");
        SOME_DOCUMENT_FIELDS.put("secondKey", 100);
    }

    @Mock SandboxDocumentFilter documentFilterMock;

    @Test
    public void builder_shouldAllowIndividualDocumentFields() {
        SandboxDocumentTextDataExtractionTask result = SandboxDocumentTextDataExtractionTask.builder()
                .withDocumentField(SOME_KEY, SOME_VALUE)
                .build();

        assertThat(result.getResult().getDocumentFields(), hasEntry(SOME_KEY, (Object) SOME_VALUE));
    }

    @Test
    public void builder_shouldAllowDocumentFieldsToBeSet() {
        SandboxDocumentTextDataExtractionTask result = SandboxDocumentTextDataExtractionTask.builder()
                .withDocumentFields(SOME_DOCUMENT_FIELDS)
                .build();

        assertThat(result.getResult().getDocumentFields(), hasEntry("firstKey", (Object) "firstValue"));
        assertThat(result.getResult().getDocumentFields(), hasEntry("secondKey", (Object) 100));
    }

    @Test
    public void builder_shouldAllowDocumentFilter() {
        SandboxDocumentTextDataExtractionTask result = SandboxDocumentTextDataExtractionTask.builder()
                .withDocumentField(SOME_KEY, SOME_VALUE)
                .withDocumentFilter(documentFilterMock)
                .build();

        assertThat(result.getDocumentFilter(), is(documentFilterMock));
    }

}

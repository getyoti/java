package com.yoti.api.client.sandbox.docs.request.task;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SandboxDocumentTextDataExtractionTaskResult {

    @JsonProperty("document_fields")
    private final Map<String, Object> documentFields;

    SandboxDocumentTextDataExtractionTaskResult(Map<String, Object> documentFields) {
        this.documentFields = documentFields;
    }

    public Map<String, Object> getDocumentFields() {
        return documentFields;
    }
}

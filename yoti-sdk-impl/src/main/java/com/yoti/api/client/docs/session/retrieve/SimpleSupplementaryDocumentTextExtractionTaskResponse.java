package com.yoti.api.client.docs.session.retrieve;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleSupplementaryDocumentTextExtractionTaskResponse extends SimpleTaskResponse implements SupplementaryDocumentTextExtractionTaskResponse {

    @Override
    public List<GeneratedSupplementaryDocumentTextDataCheckResponse> getGeneratedTextDataChecks() {
        return filterGeneratedChecksByType(GeneratedSupplementaryDocumentTextDataCheckResponse.class);
    }
}

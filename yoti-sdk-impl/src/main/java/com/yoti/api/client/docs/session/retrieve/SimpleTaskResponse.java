package com.yoti.api.client.docs.session.retrieve;

import java.util.ArrayList;
import java.util.List;

import com.yoti.api.client.docs.DocScanConstants;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = SimpleTaskResponse.class, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleTextExtractionTaskResponse.class, name = DocScanConstants.ID_DOCUMENT_TEXT_DATA_EXTRACTION),
        @JsonSubTypes.Type(value = SimpleSupplementaryDocumentTextExtractionTaskResponse.class, name = DocScanConstants.SUPPLEMENTARY_DOCUMENT_TEXT_DATA_EXTRACTION),
})
public class SimpleTaskResponse implements TaskResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("state")
    private String state;

    @JsonProperty("created")
    private String created;

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("generated_checks")
    private List<SimpleGeneratedCheckResponse> generatedChecks;

    @JsonProperty("generated_media")
    private List<SimpleGeneratedMedia> generatedMedia;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getCreated() {
        return created;
    }

    @Override
    public String getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public List<? extends GeneratedCheckResponse> getGeneratedChecks() {
        return generatedChecks;
    }

    @Override
    public List<? extends GeneratedMedia> getGeneratedMedia() {
        return generatedMedia;
    }

    protected <T extends GeneratedCheckResponse> List<T> filterGeneratedChecksByType(Class<T> clazz) {
        List<T> filteredList = new ArrayList<>();
        for (GeneratedCheckResponse generatedCheckResponse : generatedChecks) {
            if (clazz.isInstance(generatedCheckResponse)) {
                filteredList.add(clazz.cast(generatedCheckResponse));
            }
        }
        return filteredList;
    }

}

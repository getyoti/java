package com.yoti.api.client.docs.session.retrieve;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleFrameResponse implements FrameResponse {

    @JsonProperty("media")
    private SimpleMediaResponse media;

    @Override
    public MediaResponse getMedia() {
        return media;
    }

}

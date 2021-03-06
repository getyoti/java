package com.yoti.api.client.spi.remote.call;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonResourceFetcher implements ResourceFetcher {

    private final ObjectMapper objectMapper;
    private final RawResourceFetcher rawResourceFetcher;

    public static JsonResourceFetcher newInstance() {
        return JsonResourceFetcher.newInstance(new RawResourceFetcher());
    }

    public static JsonResourceFetcher newInstance(RawResourceFetcher rawResourceFetcher) {
        return new JsonResourceFetcher(new ObjectMapper(), rawResourceFetcher);
    }

    private JsonResourceFetcher(ObjectMapper objectMapper,
            RawResourceFetcher rawResourceFetcher) {
        this.objectMapper = objectMapper;
        this.rawResourceFetcher = rawResourceFetcher;
    }

    @Override
    public <T> T doRequest(SignedRequest signedRequest, Class<T> resourceClass) throws ResourceException, IOException {
        SignedRequestResponse signedRequestResponse = rawResourceFetcher.doRequest(signedRequest);
        return objectMapper.readValue(signedRequestResponse.getResponseBody(), resourceClass);
    }

}

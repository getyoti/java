package com.yoti.api.client.spi.remote.call;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

public class SignedRequest {

    private final URI uri;
    private final String method;
    private final byte[] data;
    private final Map<String, String> headers;
    private final JsonResourceFetcher jsonResourceFetcher;

    SignedRequest(final URI uri,
            final String method,
            final byte[] data,
            final Map<String, String> headers,
            JsonResourceFetcher jsonResourceFetcher) {

        this.uri = uri;
        this.method = method;
        this.data = data;
        this.headers = headers;
        this.jsonResourceFetcher = jsonResourceFetcher;
    }

    public URI getUri() {
        return uri;
    }

    public String getMethod() {
        return method;
    }

    public byte[] getData() {
        return data != null ? data.clone() : null;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public <T> T execute(Class<T> clazz) throws ResourceException, IOException {
        UrlConnector urlConnector = UrlConnector.get(uri.toString());
        return jsonResourceFetcher.doRequest(urlConnector, getMethod(), getData(), getHeaders(), clazz);
    }
}

package com.yoti.api.client.docs.session.create.task;

import com.yoti.api.client.docs.DocScanConstants;

/**
 * Requests that a TextExtractionTask be applied to each Document
 */
public class RequestedTextExtractionTask extends RequestedTask<RequestedTextExtractionTaskConfig> {

    private final RequestedTextExtractionTaskConfig config;

    RequestedTextExtractionTask(RequestedTextExtractionTaskConfig config) {
        this.config = config;
    }

    public static RequestedTextExtractionTask.Builder builder() {
        return new RequestedTextExtractionTask.Builder();
    }

    @Override
    public String getType() {
        return DocScanConstants.ID_DOCUMENT_TEXT_DATA_EXTRACTION;
    }

    @Override
    public RequestedTextExtractionTaskConfig getConfig() {
        return config;
    }

    public static class Builder {

        private String manualCheck;
        private String chipData;

        public Builder withManualCheckAlways() {
            this.manualCheck = DocScanConstants.ALWAYS;
            return this;
        }

        public Builder withManualCheckFallback() {
            this.manualCheck = DocScanConstants.FALLBACK;
            return this;
        }

        public Builder withManualCheckNever() {
            this.manualCheck = DocScanConstants.NEVER;
            return this;
        }

        public Builder withChipDataDesired() {
            this.chipData = DocScanConstants.DESIRED;
            return this;
        }

        public Builder withChipDataIgnore() {
            this.chipData = DocScanConstants.IGNORE;
            return this;
        }

        public RequestedTextExtractionTask build() {
            RequestedTextExtractionTaskConfig config = new RequestedTextExtractionTaskConfig(manualCheck, chipData);
            return new RequestedTextExtractionTask(config);
        }
        
    }

}

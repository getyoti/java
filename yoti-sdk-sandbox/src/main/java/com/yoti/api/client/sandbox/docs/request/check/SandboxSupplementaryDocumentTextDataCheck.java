package com.yoti.api.client.sandbox.docs.request.check;

import static com.yoti.api.client.spi.remote.util.Validation.notNull;

import java.util.HashMap;
import java.util.Map;

import com.yoti.api.client.sandbox.docs.request.SandboxDocumentFilter;
import com.yoti.api.client.sandbox.docs.request.check.report.SandboxCheckReport;

public class SandboxSupplementaryDocumentTextDataCheck extends SandboxDocumentCheck {

    SandboxSupplementaryDocumentTextDataCheck(SandboxSupplementaryDocumentTextDataCheckResult result, SandboxDocumentFilter documentFilter) {
        super(result, documentFilter);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public SandboxSupplementaryDocumentTextDataCheckResult getResult() {
        return (SandboxSupplementaryDocumentTextDataCheckResult) super.getResult();
    }

    /**
     * Builder for {@link SandboxSupplementaryDocumentTextDataCheck}
     */
    public static class Builder extends SandboxDocumentCheck.Builder<Builder> {

        private Map<String, Object> documentFields;

        private Builder() {
        }

        public Builder withDocumentField(String key, Object value) {
            if (documentFields == null) {
                documentFields = new HashMap<>();
            }

            this.documentFields.put(key, value);
            return self();
        }

        public Builder withDocumentFields(Map<String, Object> documentFields) {
            this.documentFields = documentFields;
            return self();
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public SandboxSupplementaryDocumentTextDataCheck build() {
            notNull(recommendation, "recommendation");

            SandboxCheckReport report = new SandboxCheckReport(recommendation, breakdown);
            SandboxSupplementaryDocumentTextDataCheckResult result = new SandboxSupplementaryDocumentTextDataCheckResult(report, documentFields);

            return new SandboxSupplementaryDocumentTextDataCheck(result, documentFilter);
        }
    }
}

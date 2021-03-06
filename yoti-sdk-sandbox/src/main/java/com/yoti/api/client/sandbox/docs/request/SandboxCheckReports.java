package com.yoti.api.client.sandbox.docs.request;

import static com.yoti.api.client.docs.DocScanConstants.ID_DOCUMENT_AUTHENTICITY;
import static com.yoti.api.client.docs.DocScanConstants.ID_DOCUMENT_COMPARISON;
import static com.yoti.api.client.docs.DocScanConstants.ID_DOCUMENT_FACE_MATCH;
import static com.yoti.api.client.docs.DocScanConstants.ID_DOCUMENT_TEXT_DATA_CHECK;
import static com.yoti.api.client.docs.DocScanConstants.LIVENESS;
import static com.yoti.api.client.docs.DocScanConstants.SUPPLEMENTARY_DOCUMENT_TEXT_DATA_CHECK;
import static com.yoti.api.client.docs.DocScanConstants.THIRD_PARTY_IDENTITY;

import java.util.ArrayList;
import java.util.List;

import com.yoti.api.client.sandbox.docs.request.check.SandboxDocumentAuthenticityCheck;
import com.yoti.api.client.sandbox.docs.request.check.SandboxDocumentTextDataCheck;
import com.yoti.api.client.sandbox.docs.request.check.SandboxDocumentFaceMatchCheck;
import com.yoti.api.client.sandbox.docs.request.check.SandboxIdDocumentComparisonCheck;
import com.yoti.api.client.sandbox.docs.request.check.SandboxLivenessCheck;
import com.yoti.api.client.sandbox.docs.request.check.SandboxSupplementaryDocumentTextDataCheck;
import com.yoti.api.client.sandbox.docs.request.check.SandboxThirdPartyIdentityCheck;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SandboxCheckReports {

    @JsonProperty(ID_DOCUMENT_TEXT_DATA_CHECK)
    private final List<SandboxDocumentTextDataCheck> documentTextDataChecks;

    @JsonProperty(ID_DOCUMENT_AUTHENTICITY)
    private final List<SandboxDocumentAuthenticityCheck> documentAuthenticityChecks;

    @JsonProperty(LIVENESS)
    private final List<SandboxLivenessCheck> livenessChecks;

    @JsonProperty(ID_DOCUMENT_FACE_MATCH)
    private final List<SandboxDocumentFaceMatchCheck> documentFaceMatchChecks;

    @JsonProperty(ID_DOCUMENT_COMPARISON)
    private final List<SandboxIdDocumentComparisonCheck> idDocumentComparisonChecks;

    @JsonProperty(SUPPLEMENTARY_DOCUMENT_TEXT_DATA_CHECK)
    private final List<SandboxSupplementaryDocumentTextDataCheck> supplementaryDocumentTextDataChecks;

    @JsonProperty(THIRD_PARTY_IDENTITY)
    private final SandboxThirdPartyIdentityCheck thirdPartyIdentityCheck;

    @JsonProperty("async_report_delay")
    private final Integer asyncReportDelay;

    SandboxCheckReports(List<SandboxDocumentTextDataCheck> documentTextDataChecks,
            List<SandboxDocumentAuthenticityCheck> documentAuthenticityChecks,
            List<SandboxLivenessCheck> livenessChecks,
            List<SandboxDocumentFaceMatchCheck> documentFaceMatchChecks,
            List<SandboxIdDocumentComparisonCheck> idDocumentComparisonChecks,
            List<SandboxSupplementaryDocumentTextDataCheck> supplementaryDocumentTextDataChecks,
            SandboxThirdPartyIdentityCheck thirdPartyIdentityCheck,
            Integer asyncReportsDelay) {
        this.documentTextDataChecks = documentTextDataChecks;
        this.documentAuthenticityChecks = documentAuthenticityChecks;
        this.livenessChecks = livenessChecks;
        this.documentFaceMatchChecks = documentFaceMatchChecks;
        this.idDocumentComparisonChecks = idDocumentComparisonChecks;
        this.supplementaryDocumentTextDataChecks = supplementaryDocumentTextDataChecks;
        this.thirdPartyIdentityCheck = thirdPartyIdentityCheck;
        this.asyncReportDelay = asyncReportsDelay;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<SandboxDocumentTextDataCheck> getDocumentTextDataChecks() {
        return documentTextDataChecks;
    }

    public List<SandboxDocumentAuthenticityCheck> getDocumentAuthenticityChecks() {
        return documentAuthenticityChecks;
    }

    public List<SandboxLivenessCheck> getLivenessChecks() {
        return livenessChecks;
    }

    public List<SandboxDocumentFaceMatchCheck> getDocumentFaceMatchChecks() {
        return documentFaceMatchChecks;
    }

    public List<SandboxIdDocumentComparisonCheck> getIdDocumentComparisonChecks() { return idDocumentComparisonChecks; }

    public List<SandboxSupplementaryDocumentTextDataCheck> getSupplementaryDocumentTextDataChecks() {
        return supplementaryDocumentTextDataChecks;
    }

    public SandboxThirdPartyIdentityCheck getThirdPartyIdentityCheck() {
        return thirdPartyIdentityCheck;
    }

    public Integer getAsyncReportDelay() {
        return asyncReportDelay;
    }

    /**
     * Builder for {@link SandboxCheckReports}
     */
    public static class Builder {

        private List<SandboxDocumentTextDataCheck> textDataCheck = new ArrayList<>();

        private List<SandboxDocumentAuthenticityCheck> documentAuthenticityCheck = new ArrayList<>();

        private List<SandboxLivenessCheck> livenessCheck = new ArrayList<>();

        private List<SandboxDocumentFaceMatchCheck> documentFaceMatchCheck = new ArrayList<>();

        private List<SandboxIdDocumentComparisonCheck> idDocumentComparisonCheck = new ArrayList<>();

        private List<SandboxSupplementaryDocumentTextDataCheck> supplementaryDocumentTextDataCheck = new ArrayList<>();

        private SandboxThirdPartyIdentityCheck thirdPartyIdentityCheck;

        private Integer asyncReportDelay;

        private Builder() {}

        public Builder withDocumentTextDataCheck(SandboxDocumentTextDataCheck textDataCheckReport) {
            this.textDataCheck.add(textDataCheckReport);
            return this;
        }

        public Builder withDocumentAuthenticityCheck(SandboxDocumentAuthenticityCheck documentAuthenticityReport) {
            this.documentAuthenticityCheck.add(documentAuthenticityReport);
            return this;
        }

        public Builder withLivenessCheck(SandboxLivenessCheck livenessReport) {
            this.livenessCheck.add(livenessReport);
            return this;
        }

        public Builder withDocumentFaceMatchCheck(SandboxDocumentFaceMatchCheck documentFaceMatchReport) {
            this.documentFaceMatchCheck.add(documentFaceMatchReport);
            return this;
        }

        public Builder withIdDocumentComparisonCheck(SandboxIdDocumentComparisonCheck sandboxIdDocumentComparisonCheck) {
            this.idDocumentComparisonCheck.add(sandboxIdDocumentComparisonCheck);
            return this;
        }

        public Builder withSupplementaryDocumentTextDataCheck(SandboxSupplementaryDocumentTextDataCheck sandboxSupplementaryDocumentTextDataCheck) {
            this.supplementaryDocumentTextDataCheck.add(sandboxSupplementaryDocumentTextDataCheck);
            return this;
        }

        public Builder withThirdPartyIdentityCheck(SandboxThirdPartyIdentityCheck thirdPartyIdentityCheck) {
            this.thirdPartyIdentityCheck = thirdPartyIdentityCheck;
            return this;
        }

        public Builder withAsyncReportDelay(int asyncReportDelay) {
            this.asyncReportDelay = asyncReportDelay;
            return this;
        }

        public SandboxCheckReports build() {
            return new SandboxCheckReports(textDataCheck, documentAuthenticityCheck, livenessCheck, documentFaceMatchCheck, idDocumentComparisonCheck,
                    supplementaryDocumentTextDataCheck, thirdPartyIdentityCheck, asyncReportDelay);
        }

    }
}

package com.yoti.api.client.sandbox.docs.request.check;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import com.yoti.api.client.sandbox.docs.request.SandboxDocumentFilter;
import com.yoti.api.client.sandbox.docs.request.check.report.SandboxBreakdown;
import com.yoti.api.client.sandbox.docs.request.check.report.SandboxRecommendation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SandboxIdDocumentComparisonCheckTest {

    @Mock SandboxRecommendation sandboxRecommendationMock;
    @Mock SandboxBreakdown sandboxBreakdownMock;
    @Mock SandboxDocumentFilter secondaryDocumentFilterMock;

    @Test
    public void builder_shouldThrowExceptionForMissingRecommendation() {
        try {
            SandboxIdDocumentComparisonCheck.builder().build();
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), containsString("recommendation"));
            return;
        }
        fail("Expected an exception");
    }

    @Test
    public void builder_shouldBuildCorrectly() {
        SandboxIdDocumentComparisonCheck result = SandboxIdDocumentComparisonCheck.builder()
                .withRecommendation(sandboxRecommendationMock)
                .withBreakdown(sandboxBreakdownMock)
                .withSecondaryDocumentFilter(secondaryDocumentFilterMock)
                .build();

        assertThat(result.getSecondaryDocumentFilter(), is(secondaryDocumentFilterMock));
        assertThat(result.getResult().getReport().getBreakdown(), hasSize(1));
        assertThat(result.getResult().getReport().getRecommendation(), is(sandboxRecommendationMock));
    }

}

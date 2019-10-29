package com.yoti.api.client.shareurl.policy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.yoti.api.client.shareurl.constraint.Constraint;
import com.yoti.api.client.shareurl.constraint.SourceConstraint;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SimpleWantedAttributeBuilderTest {

    public static final String SOME_NAME = "someName";
    public static final String SOME_DERIVATION = "someDerivation";

    @Mock
    List<Constraint> constraintListMock;

    @Test
    public void buildsAnAttribute() {
        WantedAttribute result = new SimpleWantedAttributeBuilder()
                .withName(SOME_NAME)
                .withDerivation(SOME_DERIVATION)
                .withOptional(true)
                .build();

        assertEquals(SOME_NAME, result.getName());
        assertEquals(SOME_DERIVATION, result.getDerivation());
        assertEquals(true, result.isOptional());
    }

    @Test
    public void buildsAnAttributeWithSourceConstraint() {
        when(constraintListMock.size()).thenReturn(1);

        WantedAttribute result = new SimpleWantedAttributeBuilder()
                .withName(SOME_NAME)
                .withDerivation(SOME_DERIVATION)
                .withOptional(true)
                .withConstraints(constraintListMock)
                .withAcceptSelfAsserted(true)
                .build();

        assertEquals(SOME_NAME, result.getName());
        assertEquals(SOME_DERIVATION, result.getDerivation());
        assertEquals(true, result.isOptional());
        assertEquals(true, result.getAcceptSelfAsserted());
        assertThat(result.getConstraints(), hasSize(1));
        assertEquals(result.getConstraints(), constraintListMock);
    }

}

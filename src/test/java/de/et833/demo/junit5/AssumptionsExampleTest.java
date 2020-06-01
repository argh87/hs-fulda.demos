package de.et833.demo.junit5;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssumptionsExampleTest {

    @Test
    void testInAllEnvironments() {
        Assumptions.assumingThat("DE".equals(Locale.getDefault().getCountry()),
            () -> assertEquals("ein string", "ein string"));
        assertEquals("a string", "a string");
    }
}

package de.et833.demo.junit5;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class AssertionsExamplesTest {

    @Test void testMicrosecondsOfADay() {
        assertEquals(86400000000L, 24L * 60 * 60 * 1000 * 1000);
    }

    @Test void testMicrosecondsOfADayUnequal() {
        assertNotEquals(86400000000L, 24 * 60 * 60 * 1000 * 1000);
    }

    @Test void groupedAssertion() {
        assertAll(
            () -> assertEquals(100, 10*10),
            () -> assertNotNull(new Object()));
    }

    @Test void exceptionOnEmptyList() {
        List<Integer> numbers = new ArrayList<>();
        Throwable ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            numbers.get(0);
        });
        assertEquals("Index 0 out-of-bounds for length 0", ex.getMessage());
    }
}

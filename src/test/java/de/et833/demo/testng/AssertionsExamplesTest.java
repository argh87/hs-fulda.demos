package de.et833.demo.testng;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class AssertionsExamplesTest {

    @Test
    public void testMicrosecondsOfADay() {
        assertEquals(86400000000L, 24L * 60 * 60 * 1000 * 1000);
    }

    @Test
    public void testMicrosecondsOfADayUnegal() {
        assertNotEquals(86400000000L, 24 * 60 * 60 * 1000 * 1000);
    }

    @Test
    public void groupedAssertion() {
        assertEquals(100, 10 * 10);
        assertNotNull(new Object());
    }

    @Test
    public void exceptionOnEmptyList() {
        List<Integer> numbers = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            numbers.get(0);
        });

        //Message kann nicht getestet werden
    }
}

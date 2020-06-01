package de.et833.demo.junit5;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class LifecycleTest {

    static List<Integer> array;

    @BeforeAll
    static void initAll() {
        array = new ArrayList<>();
    }

    @BeforeEach
    void setup() {
        array.add(10);
    }

    @Test
    void assertSize() {
        Assertions.assertTrue(array.size() > 0);
    }

    @Test
    void assertContent() {
        Assertions.assertEquals(10, (int) array.get(0));
    }
}

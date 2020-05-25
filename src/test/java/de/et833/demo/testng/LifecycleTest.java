package de.et833.demo.testng;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LifecycleTest {

    static List<Integer> array;

    @BeforeSuite
    public static void initAll() {
        array = new ArrayList<>();
    }

    @BeforeTest
    public void setup() {
        array.add(10);
    }

    @Test
    public void assertSize() {
        assertTrue(array.size() > 0);
    }

    @Test
    public void assertContent() {
        assertEquals(10, (int) array.get(0));
    }
}

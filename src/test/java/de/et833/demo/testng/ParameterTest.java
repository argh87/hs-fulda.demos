package de.et833.demo.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * depedency: org.testng:testng
 */
public class ParameterTest {
    @DataProvider(name = "intProvider")
    public static Object[][] data() {
        return new Object[][]{{5, 5, 25}, {2, 8, 16}, {12, 6, 72}, {1, 1, 1}};
    }

    @Test(dataProvider = "intProvider")
    public void testParameters(int a, int b, int p) {
        assertEquals(a * b, p);
    }

    @Test(dataProvider = "stringProviedr")
    public void testWithSimpleMethodSource(String argument) {
        assertTrue(argument.equals("foo") || argument.equals("bar"));
    }

    @DataProvider(name = "stringProviedr")
    public Object[][] stringProvider() {
        return new Object[][]{{"foo"}, {"bar"},};
    }

    @Test(dataProvider = "provideTestData")
    public void testMethodSource(long number, boolean isOdd) {

        if (isOdd) {
            assertEquals(1, number % 2);
        }

        if (!isOdd) {
            assertEquals(0, number % 2);
        }
    }

    @DataProvider(name = "provideTestData")
    public Object[][] provideTestData() {
        return new Object[][]{{1L, true}, {2L, false}};
    }
}

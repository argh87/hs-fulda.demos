package de.et833.demo.junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * depedency: org.junit:junit
 */
@RunWith(Parameterized.class)
public class ParameterTest {
    private final int a;
    private final int b;
    private final int p;

    public ParameterTest(int a, int b, int p) {
        this.a = a;
        this.b = b;
        this.p = p;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{5, 5, 25}, {2, 8, 16}, {12, 6, 72}, {1, 1, 1}});
    }

    @Test
    public void testParameters() {
        assertEquals(a * b, p);
    }
}

package de.et833.demo.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://jaxenter.de/highlights-junit-5-65986
 * <p>
 * dependency org.junit.jupiter:junit-jupiter-api
 */
public class FactoryTest {

    @TestFactory
    Stream<DynamicTest> allFibonaccisAreOdd() {
        return IntStream.of(1, 2, 4, 5, 7, 8, 10, 11, 13)
            .boxed()
            .map(this::fibonacci)
            .map(number ->
                DynamicTest.dynamicTest(
                    "Fibonacci = " + number,
                    () -> Assertions.assertTrue(number % 2 != 0)));
    }

    Integer fibonacci(Integer num) {
        if (num <= 0) return 0;
        if (num == 1) return 1;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}

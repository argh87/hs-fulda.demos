package de.et833.demo.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * depedency: org.junit.jupiter:junit-jupiter-params
 */
public class ParameterTest {

    @ParameterizedTest(name = "Test mit Int-Wert \"{0}\"")
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String argument) {
        assertTrue(argument.equals("foo") || argument.equals("bar"));
    }

    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testMethodSource(long number, boolean isOdd) {
        Assertions.assertAll("oddity", () -> {
            if (isOdd) {
                assertEquals(1, number % 2);
            }
        }, () -> {
            if (!isOdd) {
                assertEquals(0, number % 2);
            }
        });
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(Arguments.of(1L, true), Arguments.of(2L, false));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"19.04.2018", "01.05.2018"})
    void isValueSource(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate argument) {
        assertEquals(2018, argument.getYear());
    }

    @ParameterizedTest
    @CsvSource({"5,5,25", "2,8,16", "12,6,72"})
    void testWithCsvSource(int a, int b, int p) {
        assertEquals(a * b, p);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/META-INF/parameters.csv")
    void testCsvFileSource(int a, int b, int p) {
        assertEquals(a * b, p);
    }

    @ParameterizedTest
    @EnumSource(value = SomeEnum.class, names = {"EINS", "DREI"})
    void testEnumSource(SomeEnum someEnum) {
        switch (someEnum) {
            case EINS:
            case DREI:

                break;
            default:
                Assertions.fail("Failed! :P");
        }
    }

    enum SomeEnum {
        EINS, ZWEI, DREI, VIER
    }

    @ParameterizedTest
    @ArgumentsSource(SomeArgumentsProvider.class)
    void testArgumentsSource(String argument) {
        assertNotNull(argument);
    }

    static class SomeArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of("Helmut", "Werner", "Klaus")
                    .map(Arguments::of);
        }
    }

}

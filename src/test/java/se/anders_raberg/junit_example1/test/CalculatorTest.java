package se.anders_raberg.junit_example1.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import se.anders_raberg.junit_example1.Calculator;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({ "1, 2, 3", "5, 5, 10", "-2, 2, 0", "10, -5, 5", "0, 0, 0" })
    void testAddition(int a, int b, int expectedSum) {
        assertEquals(expectedSum, calculator.add(a, b));
    }

    // Method that provides test parameters
    static Stream<Arguments> multiplicationTestCases() {
        return Stream.of( //
                Arguments.of(2, 3, 6), //
                Arguments.of(-2, 3, -6), //
                Arguments.of(0, 5, 0), //
                Arguments.of(7, 1, 7));
    }

    @ParameterizedTest
    @MethodSource("multiplicationTestCases")
    void testMultiplication(int a, int b, int expectedProduct) {
        assertEquals(expectedProduct, calculator.multiply(a, b));
    }
}

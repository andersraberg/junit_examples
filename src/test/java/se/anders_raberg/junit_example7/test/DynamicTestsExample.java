package se.anders_raberg.junit_example7.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class DynamicTestsExample {

    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        return numbers.stream()
                .map(num -> DynamicTest.dynamicTest("Test if " + num + " is positive", () -> assertTrue(num > 0)));
    }
}

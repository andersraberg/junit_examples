package se.anders_raberg.junit_example7.test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class) // Enables ordering
class OrderedTests {

    private static String value = "";

    @Test
    @Order(1)
    void testA() {
        value += "A";
        assertEquals("A", value);
    }

    @Test
    @Order(2)
    void testB() {
        value += "B";
        assertEquals("AB", value);
    }

    @Test
    @Order(3)
    void testC() {
        value += "C";
        assertEquals("ABC", value);
    }
}

package se.anders_raberg.junit_example7.test;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

class RepeatedTestExample {
    private Random rnd = new Random();

    @RepeatedTest(5) // Run test 5 times
    void testRandomNumberGeneration() {
        int randomValue = rnd.nextInt(10);
        assertTrue(randomValue >= 0 && randomValue < 10);
    }
}

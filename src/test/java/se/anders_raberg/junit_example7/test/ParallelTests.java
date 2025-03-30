package se.anders_raberg.junit_example7.test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParallelTests {

    @Test
    @Order(1)
    @Execution(ExecutionMode.CONCURRENT) // Run in parallel
    void testA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        assertTrue(true);
    }

    @Test
    @Order(2)
    @Execution(ExecutionMode.CONCURRENT) // Run in parallel
    void testB() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        assertTrue(true);
    }
}

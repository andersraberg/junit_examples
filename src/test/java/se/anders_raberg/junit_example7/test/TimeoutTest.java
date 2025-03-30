package se.anders_raberg.junit_example7.test;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

class TimeoutTest {

    @Test
    @Execution(ExecutionMode.CONCURRENT) // Run in parallel
    void testShouldCompleteWithinTimeLimit() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            // Simulate slow process (e.g., database query, network call)
            Thread.sleep(1500);
        });
    }
}

package se.anders_raberg.junit_example7.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class VerifyTest {

    @Test
    void testMethodCalls() {
        MyService service = mock(MyService.class);

        // Act
        service.process();
        service.process();

        // Verify the method was called **exactly 2 times**
        verify(service, times(2)).process();

        // Verify it was NEVER called with a specific argument
        verify(service, never()).process("Invalid");
    }
}

class MyService {
    void process() {
        /* Dummy */ }

    void process(String value) {
        /* Dummy */ }
}

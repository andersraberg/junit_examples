package se.anders_raberg.junit_example3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import se.anders_raberg.junit_example3.PaymentService;

@ExtendWith(MockitoExtension.class) // Enable Mockito in JUnit 5
class PaymentServiceTest {

    @Spy
    private PaymentService paymentService; // Spy the real service

    @Test
    void testProcessPaymentWithMockedFee() {
        // Arrange: Override only calculateFee()
        doReturn(2.0).when(paymentService).calculateFee(100.0);

        // Act
        String result = paymentService.processPayment(100.0);

        // Assert
        assertEquals("Processed payment of $100.0 with a fee of $2.0", result);

        // Verify the method was called
        verify(paymentService, times(1)).calculateFee(100.0);
    }
}

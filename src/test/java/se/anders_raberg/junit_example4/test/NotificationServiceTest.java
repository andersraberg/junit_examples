package se.anders_raberg.junit_example4.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import se.anders_raberg.junit_example4.MessageSender;
import se.anders_raberg.junit_example4.NotificationService;

@ExtendWith(MockitoExtension.class) // Enable Mockito in JUnit 5
class NotificationServiceTest {

    @Mock
    private MessageSender messageSender; // Mock the dependency

    @InjectMocks
    private NotificationService notificationService; // Inject mock into service

    @Test
    void testNotifyUser_CapturesMessage() {
        // Arrange
        ArgumentCaptor<String> recipientCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);

        // Act
        notificationService.notifyUser("123");

        // Assert: Capture arguments from sendMessage call
        verify(messageSender).sendMessage(recipientCaptor.capture(), messageCaptor.capture());

        // Validate captured arguments
        assertEquals("123", recipientCaptor.getValue());
        assertEquals("Hello, user 123!", messageCaptor.getValue());
    }
}

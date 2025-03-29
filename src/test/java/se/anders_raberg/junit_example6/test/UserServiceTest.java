package se.anders_raberg.junit_example6.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import se.anders_raberg.junit_example6.UserService;
import se.anders_raberg.junit_example6.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Test
    void testCreateUser_WithMockedUserId() {
        try (MockedStatic<Utils> mockedUtils = Mockito.mockStatic(Utils.class)) {
            // Arrange: Mock static method
            mockedUtils.when(Utils::generateUserId).thenReturn("mocked-uuid-123");

            // Act
            UserService userService = new UserService();
            String result = userService.createUser();

            // Assert
            assertEquals("User ID: mocked-uuid-123", result);

            // Verify that the static method was called
            mockedUtils.verify(Utils::generateUserId);
        }
    }
}

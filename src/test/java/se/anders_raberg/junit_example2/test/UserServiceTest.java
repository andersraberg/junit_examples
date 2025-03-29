package se.anders_raberg.junit_example2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import se.anders_raberg.junit_example2.User;
import se.anders_raberg.junit_example2.UserRepository;
import se.anders_raberg.junit_example2.UserService;

@ExtendWith(MockitoExtension.class) // Enable Mockito support in JUnit 5
class UserServiceTest {

    @Mock
    private UserRepository userRepository; // Mock the dependency
    
 //   @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }          

    @Test
    void testGetUserName_UserExists() {
        // Arrange: Define behavior of the mock
        when(userRepository.findById("123")).thenReturn(Optional.of(new User("123", "Alice")));

        // Act: Call the method under test
        String result = userService.getUserName("123");

        // Assert: Verify the expected result
        assertEquals("Alice", result);

        // Verify that findById was called exactly once
        verify(userRepository, times(1)).findById("123");
    }

    @Test
    void testGetUserName_UserNotFound() {
        // Arrange: Mock behavior when user is not found
        when(userRepository.findById("999")).thenReturn(Optional.empty());

        // Act
        String result = userService.getUserName("999");

        // Assert
        assertEquals("Unknown User", result);

        // Verify method call
        verify(userRepository, times(1)).findById("999");
    }
}

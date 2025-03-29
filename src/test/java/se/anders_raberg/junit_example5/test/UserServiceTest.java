package se.anders_raberg.junit_example5.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import se.anders_raberg.junit_example5.UserRepository;
import se.anders_raberg.junit_example5.UserService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserNameAsync() throws ExecutionException, InterruptedException {
        // Arrange: Mock an asynchronous response
        when(userRepository.findUserById("123"))
                .thenReturn(CompletableFuture.completedFuture("Alice"));

        // Act: Call the async method
        CompletableFuture<String> future = userService.getUserNameAsync("123");

        // Assert: Wait for the future to complete and verify the result
        assertEquals("User: Alice", future.get());

        // Verify the method was called
        verify(userRepository, times(1)).findUserById("123");
    }
}

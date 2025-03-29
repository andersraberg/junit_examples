package se.anders_raberg.junit_example5;

import java.util.concurrent.CompletableFuture;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CompletableFuture<String> getUserNameAsync(String userId) {
        return userRepository.findUserById(userId)
                .thenApply(name -> "User: " + name);
    }
}

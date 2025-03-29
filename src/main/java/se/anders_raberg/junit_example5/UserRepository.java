package se.anders_raberg.junit_example5;

import java.util.concurrent.CompletableFuture;

public interface UserRepository {
    CompletableFuture<String> findUserById(String userId);
}

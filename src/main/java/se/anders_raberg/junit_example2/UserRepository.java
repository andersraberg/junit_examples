package se.anders_raberg.junit_example2;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(String id);
}

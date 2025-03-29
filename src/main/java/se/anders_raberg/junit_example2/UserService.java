package se.anders_raberg.junit_example2;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(String userId) {
        return userRepository.findById(userId)
                .map(User::getName)
                .orElse("Unknown User");
    }
}

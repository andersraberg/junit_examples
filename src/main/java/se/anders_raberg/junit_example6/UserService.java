package se.anders_raberg.junit_example6;

public class UserService {
    public String createUser() {
        return "User ID: " + Utils.generateUserId();
    }
}

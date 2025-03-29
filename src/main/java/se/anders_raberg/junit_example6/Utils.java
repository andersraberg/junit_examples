package se.anders_raberg.junit_example6;

import java.util.UUID;

public class Utils {
    public static String generateUserId() {
        return UUID.randomUUID().toString();
    }
}

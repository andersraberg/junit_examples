package se.anders_raberg.junit_example4;

public class NotificationService {
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void notifyUser(String userId) {
        String message = "Hello, user " + userId + "!";
        messageSender.sendMessage(userId, message);
    }
}

import Strategy.EmailService;

public class Notification {
    private String sender;
    private String message;
    private EmailService emailService;

    public Notification(EmailService emailService) {
        this.emailService = emailService;
    }

    public void send(String message) {
        emailService.send(message);
    }
}

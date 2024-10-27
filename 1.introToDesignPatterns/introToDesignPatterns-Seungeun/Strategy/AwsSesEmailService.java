package Strategy;

public class AwsSesEmailService implements EmailService {
    @Override
    public void send(String message) {
        System.out.println(message);
        System.out.println(" - Sending email using AWS SES");
    }

}

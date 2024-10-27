package Strategy;

public class StibeeEmailService implements EmailService {
    @Override
    public void send(String message) {
        System.out.println(message);
        System.out.println(" - Sending email using Stibee(email platform)");
    }

}

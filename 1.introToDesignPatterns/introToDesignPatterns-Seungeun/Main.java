import Strategy.AwsSesEmailService;
import Strategy.EmailService;
import Strategy.StibeeEmailService;

public class Main {
    public static void main(String[] args) {
        Notification abnormalUrl = new Notification(new AwsSesEmailService());
        abnormalUrl.send("=== Abnormal URL ===");

        Notification customReport = new Notification(new StibeeEmailService());
        customReport.send("=== Custom Daily Report ===");

        // 메일 발송 플랫폼을 변경할 수도 있기 때문에 예시로 작성 해 봄
    }
}

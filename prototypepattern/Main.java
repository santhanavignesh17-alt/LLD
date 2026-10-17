
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        EmailRegistry registry = new EmailRegistry();

        EmailTemplate email1 = registry.getEmailTemplate("welcome");
        email1.setcontent("Welcome to Take U Forward!");

        email1.send("student@gmail.com");

        EmailTemplate email2 = registry.getEmailTemplate("welcome");
        email2.send("another");

        email2.setcontent(
            "Welcome to Take U Forward! We are glad to have you."
        );
        email2.send("another@gmail.com");
    }
}

interface EmailTemplate extends Cloneable {
    void setcontent(String content);
    void send(String to);
    EmailTemplate clone();
}

class WelcomeEmail implements EmailTemplate {
    private String content;
    private String subject;

    WelcomeEmail() {
        this.subject = "Welcome to Take U Forward";
        this.content = "Hello, welcome to Take U Forward";
    }

    @Override
    public void setcontent(String content) {
        this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println(
            "Sending welcome email to " + to +
            " with subject: " + subject +
            " and content: " + content
        );
    }

    @Override
    public EmailTemplate clone() {
        try {
            return (EmailTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
}

class EmailRegistry {
    private Map<String, EmailTemplate> emailTemplates = new HashMap<>();

    public EmailRegistry() {
        emailTemplates.put("welcome", new WelcomeEmail());
    }

    public EmailTemplate getEmailTemplate(String type) {
        EmailTemplate template = emailTemplates.get(type);

        if (template == null) {
            throw new IllegalArgumentException(
                "Invalid email template type: " + type
            );
        }

        return template.clone();
    }
}

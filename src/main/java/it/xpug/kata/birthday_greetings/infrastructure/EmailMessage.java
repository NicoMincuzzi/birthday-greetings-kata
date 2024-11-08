package it.xpug.kata.birthday_greetings.infrastructure;

public class EmailMessage {
    private final String senderEmail;
    private final String email;
    private final String body;
    private final String subject;

    public EmailMessage(String senderEmail, String email, String body, String subject) {
        this.senderEmail = senderEmail;
        this.email = email;
        this.body = body;
        this.subject = subject;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }
}

package it.xpug.kata.birthday_greetings.domain;

public class MessageFormat {
    private String subject;
    private String body;
    private final EmailFormatter subjectFormatter;
    private final EmailFormatter bodyFormatter;

    public MessageFormat(EmailFormatter subjectFormatter, EmailFormatter bodyFormatter) {
        this.subjectFormatter = subjectFormatter;
        this.bodyFormatter = bodyFormatter;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public MessageFormat of(Employee employee) {
        subject = subjectFormatter.format("");
        body = bodyFormatter.format(employee.getFirstName());
        return this;
    }
}

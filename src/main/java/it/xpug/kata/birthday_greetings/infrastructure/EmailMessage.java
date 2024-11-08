package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.MessageFormatter;

public class EmailMessage {

    private final String senderEmail;
    private final Employee employee;

    public EmailMessage(String senderEmail, Employee employee) {
        this.senderEmail = senderEmail;
        this.employee = employee;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getEmail() {
        return employee.getEmail();
    }

    public String getBody(MessageFormatter messageFormatter) {
        return messageFormatter.body(employee.getFirstName());
    }

    public String getSubject(MessageFormatter messageFormatter) {
        return messageFormatter.subject();
    }
}

package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.EmailApiAdapter;
import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.MessageFormatter;

public class EmailSender implements Sender {

    private final String senderEmail;
    private final EmailApiAdapter emailApiAdapter;

    public EmailSender(String senderEmail, EmailApiAdapter emailApiAdapter) {
        this.senderEmail = senderEmail;
        this.emailApiAdapter = emailApiAdapter;
    }

    @Override
    public void sendTo(Employee employee, MessageFormatter messageFormatter) {
        EmailMessage emailMessage = new EmailMessage(senderEmail, employee);

        emailApiAdapter.send(emailMessage, messageFormatter);
    }
}

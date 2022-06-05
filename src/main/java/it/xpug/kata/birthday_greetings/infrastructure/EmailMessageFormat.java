package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.MessageFormat;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static javax.mail.Message.RecipientType.TO;

public class EmailMessageFormat implements MessageFormat {
    private final Session session;

    public EmailMessageFormat(Session session) {
        this.session = session;
    }

    @Override
    public Message of(Employee employee) {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("sender@here.com"));
            msg.setRecipient(TO, new InternetAddress(employee.email()));
            msg.setSubject(employee.subjectBirthdayGreeting());
            msg.setText(employee.bodyBirthdayGreeting());
            return msg;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

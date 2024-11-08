package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.BirthdayBodyFormatter;
import it.xpug.kata.birthday_greetings.domain.BirthdaySubjectFormatter;
import it.xpug.kata.birthday_greetings.domain.Employee;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static javax.mail.Message.RecipientType.TO;

public class EmailSender implements Sender {

    private final String smtpHost;
    private final int smtpPort;
    private final String senderEmail;

    public EmailSender(String smtpHost, int smtpPort, String senderEmail) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.senderEmail = senderEmail;
    }

    @Override
    public void sendTo(Employee employee) {
        try {
            java.util.Properties props = new java.util.Properties();
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", "" + smtpPort);
            Session session = Session.getInstance(props, null);

            String body = new BirthdayBodyFormatter().format(employee.getFirstName());
            String subject = new BirthdaySubjectFormatter().format(employee.getFirstName());

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(this.senderEmail));
            msg.setRecipient(TO, new InternetAddress(employee.getEmail()));
            msg.setSubject(subject);
            msg.setText(body);

            Transport.send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

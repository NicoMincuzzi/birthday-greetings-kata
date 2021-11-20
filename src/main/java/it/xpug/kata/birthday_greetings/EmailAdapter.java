package it.xpug.kata.birthday_greetings;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static javax.mail.Message.RecipientType.TO;
import static javax.mail.Session.getInstance;

public class EmailAdapter {
    private final String smtpHost;
    private final int smtpPort;

    public EmailAdapter(String smtpHost, int smtpPort) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
    }

    public void sendEmailTo(Employee employee) {
        try {
            send(employee.emailSubject(), employee.emailBody(), employee.emailRecipient());
        } catch (MessagingException e) {
            throw new RuntimeException();
        }
    }

    private void send(String subject, String body, String recipient) throws MessagingException {
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
        Session session = getInstance(props, null);

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("sender@here.com"));
        msg.setRecipient(TO, new InternetAddress(recipient));
        msg.setSubject(subject);
        msg.setText(body);

        Transport.send(msg);
    }
}

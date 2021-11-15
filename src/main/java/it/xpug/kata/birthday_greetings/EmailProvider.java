package it.xpug.kata.birthday_greetings;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static javax.mail.Message.RecipientType.TO;

public class EmailProvider {
    private final String smtpHost;
    private final int smtpPort;

    public EmailProvider(String smtpHost, int smtpPort) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
    }

    public void sendMessage(String subject, String body, String recipient) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
        Session session = Session.getInstance(props, null);

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("sender@here.com"));
        msg.setRecipient(TO, new InternetAddress(recipient));
        msg.setSubject(subject);
        msg.setText(body);

        Transport.send(msg);
    }
}

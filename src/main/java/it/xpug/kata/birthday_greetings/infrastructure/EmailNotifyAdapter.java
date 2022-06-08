package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.MessageFormat;
import it.xpug.kata.birthday_greetings.domain.NotifyAdapter;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static javax.mail.Message.RecipientType.TO;
import static javax.mail.Session.getInstance;
import static javax.mail.Transport.send;

public class EmailNotifyAdapter implements NotifyAdapter {
    private final String smtpHost;
    private final int smtpPort;

    public EmailNotifyAdapter(String host, int port) {
        this.smtpHost = host;
        this.smtpPort = port;
    }

    @Override
    public void sendTo(String recipient, MessageFormat message) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", "" + smtpPort);

            Message msg = new MimeMessage(getInstance(props, null));
            msg.setFrom(new InternetAddress("sender@here.com"));
            msg.setRecipient(TO, new InternetAddress(recipient));
            msg.setSubject(message.getSubject());
            msg.setText(message.getBody());
            send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

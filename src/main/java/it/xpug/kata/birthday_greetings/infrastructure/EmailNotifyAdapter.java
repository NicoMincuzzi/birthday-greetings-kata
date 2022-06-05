package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.NotifyAdapter;

import javax.mail.MessagingException;
import java.util.Properties;

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
    public void sendTo(Employee employee) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", "" + smtpPort);

            EmailMessageFormat messageFormat = new EmailMessageFormat(getInstance(props, null));
            send(messageFormat.of(employee));
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

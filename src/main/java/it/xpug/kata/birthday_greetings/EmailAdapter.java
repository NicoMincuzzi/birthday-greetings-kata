package it.xpug.kata.birthday_greetings;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;

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
            Properties props = new java.util.Properties();
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", "" + smtpPort);
            Session session = getInstance(props, null);

            Message msg = employee.emailMessage(session);

            Transport.send(msg);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}

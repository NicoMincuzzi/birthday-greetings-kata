package it.xpug.kata.birthday_greetings.infrastructure;

import javax.mail.Session;

public class SmtpServerConfiguration {
    private final String smtpHost;
    private final int smtpPort;

    public SmtpServerConfiguration(String smtpHost, int smtpPort) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
    }

    Session session() {
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
        return Session.getInstance(props, null);
    }
}

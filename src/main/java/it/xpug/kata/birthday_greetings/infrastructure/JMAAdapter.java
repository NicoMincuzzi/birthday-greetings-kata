package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.EmailApiAdapter;
import it.xpug.kata.birthday_greetings.domain.MessageFormatter;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static javax.mail.Message.RecipientType.TO;

public class JMAAdapter implements EmailApiAdapter {

    private final SmtpServerConfiguration smtpServerConfiguration;

    public JMAAdapter(SmtpServerConfiguration smtpServerConfiguration) {
        this.smtpServerConfiguration = smtpServerConfiguration;
    }

    @Override
    public void send(EmailMessage emailMessage, MessageFormatter messageFormatter) {
        try {
            Message msg = new MimeMessage(smtpServerConfiguration.session());
            msg.setFrom(new InternetAddress(emailMessage.getSenderEmail()));
            msg.setRecipient(TO, new InternetAddress(emailMessage.getEmail()));
            msg.setSubject(emailMessage.getSubject(messageFormatter));
            msg.setText(emailMessage.getBody(messageFormatter));

            Transport.send(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

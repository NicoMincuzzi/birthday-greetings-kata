package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import java.util.Objects;

public class Email {
    private final String address;
    private final EmailProvider emailProvider;

    public Email(EmailProvider emailProvider, String address) {
        this.emailProvider = emailProvider;
        this.address = address;
    }

    public void sendMessage(String subject, String body) throws MessagingException {
        emailProvider.send(subject, body, address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(address, email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}

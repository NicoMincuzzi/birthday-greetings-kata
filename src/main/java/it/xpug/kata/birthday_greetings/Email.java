package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import java.util.Objects;

public class Email {
    private final String address;

    public Email(String address) {
        this.address = address;
    }

    public void sendMessage(EmailProvider emailProvider, String subject, String body) throws MessagingException {
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

package it.xpug.kata.birthday_greetings.domain;

import it.xpug.kata.birthday_greetings.infrastructure.BirthdaySubjectFormatter;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.Objects;

public class Email {
    private final String address;

    public Email(String address) {
        this.address = address;
    }

    public String body(EmailFormatter formatter, String firstName) {
        return formatter.format(firstName);
    }

    public String subject(BirthdaySubjectFormatter birthdaySubjectFormatter) {
        return birthdaySubjectFormatter.format("");
    }

    public Address internetAddress() throws AddressException {
        return new InternetAddress(address);
    }

    public Address sender() throws AddressException {
        return new InternetAddress("sender@here.com");
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

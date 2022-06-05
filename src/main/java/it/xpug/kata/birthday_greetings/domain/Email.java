package it.xpug.kata.birthday_greetings.domain;

import it.xpug.kata.birthday_greetings.infrastructure.BirthdaySubjectFormatter;

import java.util.Objects;

public class Email {
    private final String address;

    public Email(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String subject(BirthdaySubjectFormatter birthdaySubjectFormatter) {
        return birthdaySubjectFormatter.format("");
    }

    public String body(EmailFormatter formatter, String firstName) {
        return formatter.format(firstName);
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
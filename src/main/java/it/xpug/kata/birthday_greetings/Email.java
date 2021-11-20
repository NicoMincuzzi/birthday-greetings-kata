package it.xpug.kata.birthday_greetings;

import java.util.Objects;

public class Email {
    private final String address;

    public Email(String address) {
        this.address = address;
    }

    public String body(String firstName) {
        return "Happy Birthday, dear %NAME%!".replace("%NAME%", firstName);
    }

    public String subject() {
        return "Happy Birthday!";
    }

    public String getAddress() {
        return address;
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

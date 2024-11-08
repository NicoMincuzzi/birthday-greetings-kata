package it.xpug.kata.birthday_greetings.domain;

public interface MessageFormatter {
    String subject();

    String body(String... values);
}

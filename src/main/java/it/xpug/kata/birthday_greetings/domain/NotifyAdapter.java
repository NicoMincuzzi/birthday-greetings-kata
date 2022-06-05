package it.xpug.kata.birthday_greetings.domain;

public interface NotifyAdapter {
    void send(String email, String subject, String body, String recipient);
}

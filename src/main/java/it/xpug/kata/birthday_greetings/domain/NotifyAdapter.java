package it.xpug.kata.birthday_greetings.domain;

public interface NotifyAdapter {
    void sendTo(String recipient, MessageFormat message);
}

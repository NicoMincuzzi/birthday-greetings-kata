package it.xpug.kata.birthday_greetings.domain;

import it.xpug.kata.birthday_greetings.infrastructure.EmailMessage;

public interface EmailApiAdapter {

    void send(EmailMessage emailMessage, MessageFormatter messageFormatter);
}

package it.xpug.kata.birthday_greetings.domain;

import javax.mail.Message;

public interface MessageFormat {
    Message of(Employee employee);
}

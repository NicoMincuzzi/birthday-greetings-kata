package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.MessageFormatter;

public interface Sender {

    void sendTo(Employee employee, MessageFormatter messageFormatter);
}

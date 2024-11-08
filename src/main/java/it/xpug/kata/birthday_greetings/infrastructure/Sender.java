package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.Employee;

public interface Sender {

    void sendTo(Employee employee);
}

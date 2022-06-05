package it.xpug.kata.birthday_greetings;

import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.infrastructure.EmailNotifyAdapter;
import it.xpug.kata.birthday_greetings.infrastructure.EmployeeFileRepository;
import it.xpug.kata.birthday_greetings.usecase.BirthdayService;

public class Main {
    public static void main(String[] args) {
        BirthdayService service = new BirthdayService(
                new EmployeeFileRepository("employee_data.txt"),
                new EmailNotifyAdapter("localhost", 25)
        );
        service.sendGreetings(new XDate());
    }
}
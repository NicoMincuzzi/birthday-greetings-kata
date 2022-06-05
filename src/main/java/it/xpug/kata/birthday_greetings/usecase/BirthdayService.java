package it.xpug.kata.birthday_greetings.usecase;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.EmployeeRepository;
import it.xpug.kata.birthday_greetings.domain.NotifyAdapter;
import it.xpug.kata.birthday_greetings.domain.XDate;

import java.util.List;
import java.util.stream.Collectors;

public class BirthdayService {
    private final EmployeeRepository employeeRepository;
    private final NotifyAdapter notifyAdapter;

    public BirthdayService(EmployeeRepository employeeRepository, NotifyAdapter notifyAdapter) {
        this.employeeRepository = employeeRepository;
        this.notifyAdapter = notifyAdapter;
    }

    public void sendGreetings(XDate xDate) {
        List<Employee> birthdayEmployees = employeeRepository.readAll().stream()
                .filter(it -> it.isBirthday(xDate))
                .collect(Collectors.toList());

        for (Employee birthdayEmployee : birthdayEmployees) {
            String recipient = birthdayEmployee.getEmail();
            String body = "Happy Birthday, dear %NAME%".replace("%NAME%", birthdayEmployee.getFirstName().concat("!"));
            String subject = "Happy Birthday!";
            notifyAdapter.send("sender@here.com", subject, body, recipient);
        }
    }
}

package it.xpug.kata.birthday_greetings.usecase;

import it.xpug.kata.birthday_greetings.domain.*;
import it.xpug.kata.birthday_greetings.domain.MessageFormat;

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

        for (Employee employee : birthdayEmployees) {
            MessageFormat birthdayMessage = new MessageFormat(new BirthdaySubjectFormatter(),new BirthdayBodyFormatter());
            notifyAdapter.sendTo(employee.getEmail(), birthdayMessage.of(employee));
        }
    }
}

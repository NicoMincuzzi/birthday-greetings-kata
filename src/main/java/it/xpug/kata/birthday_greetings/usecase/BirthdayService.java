package it.xpug.kata.birthday_greetings.usecase;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.EmployeeRepository;
import it.xpug.kata.birthday_greetings.infrastructure.Sender;
import it.xpug.kata.birthday_greetings.domain.XDate;

import java.util.List;

public class BirthdayService {

    private final Sender sender;
    private final EmployeeRepository employeeRepository;

    public BirthdayService(Sender sender, EmployeeRepository employeeRepository) {
        this.sender = sender;
        this.employeeRepository = employeeRepository;
    }

    public void sendGreetings(XDate xDate) {
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            if (!employee.isBirthday(xDate)) {
                continue;
            }

            sender.sendTo(employee);
        }
    }
}

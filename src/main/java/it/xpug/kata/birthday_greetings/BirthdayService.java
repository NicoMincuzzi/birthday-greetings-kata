package it.xpug.kata.birthday_greetings;

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

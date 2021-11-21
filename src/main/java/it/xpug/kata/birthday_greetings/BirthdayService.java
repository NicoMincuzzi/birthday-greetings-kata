package it.xpug.kata.birthday_greetings;

import java.util.List;

public class BirthdayService {

    private final EmailAdapter emailProvider;
    private final EmployeeRepository employeeRepository;

    public BirthdayService(EmailAdapter emailProvider, EmployeeRepository employeeRepository) {
        this.emailProvider = emailProvider;
        this.employeeRepository = employeeRepository;
    }

    public void sendGreetings(XDate xDate) {
        List<Employee> employees = employeeRepository.retrieveAll();
        for (Employee employee : employees) {
            if (employee.isBirthday(xDate)) {
                emailProvider.sendEmailTo(employee);
            }
        }
    }

}

package it.xpug.kata.birthday_greetings;

import java.util.List;

public class BirthdayService {

    private final EmailProvider emailProvider;

    public BirthdayService(EmailProvider emailProvider) {
        this.emailProvider = emailProvider;
    }

    public void sendGreetings(String fileName, XDate xDate) {
        List<Employee> employees = new EmployeeRepository(new EmployeeDao(fileName)).retrieveAll();
        for (Employee employee : employees) {
            if (employee.isBirthday(xDate)) {
                emailProvider.sendEmailTo(employee);
            }
        }
    }

}

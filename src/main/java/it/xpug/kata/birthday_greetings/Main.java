package it.xpug.kata.birthday_greetings;

public class Main {

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository(new EmployeeDao("employee_data.txt"));
        BirthdayService service = new BirthdayService(new EmailAdapter("localhost", 25), employeeRepository);
        service.sendGreetings(new XDate());
    }

}

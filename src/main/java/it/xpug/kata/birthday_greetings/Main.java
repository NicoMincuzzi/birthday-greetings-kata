package it.xpug.kata.birthday_greetings;

public class Main {
    public static void main(String[] args) throws Exception {
        BirthdayService service = new BirthdayService(new EmailProvider("localhost", 25), new EmployeeRepository("employee_data.txt"));
        service.sendGreetings(new XDate());
    }
}

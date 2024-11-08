package it.xpug.kata.birthday_greetings;

public class Main {

    public static void main(String[] args) {
        Sender emailSender = new EmailSender("localhost", 25, "sender@here.com");
        EmployeeRepository employeeRepository = new EmployeeFileRepository("employee_data.txt");
        BirthdayService service = new BirthdayService(emailSender, employeeRepository);
        service.sendGreetings(new XDate());
    }

}

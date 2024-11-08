package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, MessagingException {
        Sender emailSender = new EmailSender("localhost", 25);
        EmployeeRepository employeeRepository = new EmployeeFileRepository("employee_data.txt");
        BirthdayService service = new BirthdayService(emailSender, employeeRepository);
        service.sendGreetings(new XDate());
    }

}

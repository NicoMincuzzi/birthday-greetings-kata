package it.xpug.kata.birthday_greetings;

import it.xpug.kata.birthday_greetings.domain.EmployeeRepository;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.infrastructure.EmailSender;
import it.xpug.kata.birthday_greetings.infrastructure.EmployeeFileRepository;
import it.xpug.kata.birthday_greetings.infrastructure.Sender;
import it.xpug.kata.birthday_greetings.infrastructure.SmtpServerConfiguration;
import it.xpug.kata.birthday_greetings.usecase.BirthdayService;

public class Main {

    public static void main(String[] args) {
        SmtpServerConfiguration smtpServerConfiguration = new SmtpServerConfiguration("localhost", 25);
        Sender emailSender = new EmailSender(smtpServerConfiguration, "sender@here.com");
        EmployeeRepository employeeRepository = new EmployeeFileRepository("employee_data.txt");

        BirthdayService service = new BirthdayService(emailSender, employeeRepository);
        service.sendGreetings(new XDate());
    }

}

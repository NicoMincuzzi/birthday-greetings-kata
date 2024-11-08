package it.xpug.kata.birthday_greetings;

import it.xpug.kata.birthday_greetings.domain.EmailApiAdapter;
import it.xpug.kata.birthday_greetings.domain.EmployeeRepository;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.infrastructure.EmailSender;
import it.xpug.kata.birthday_greetings.infrastructure.EmployeeFileRepository;
import it.xpug.kata.birthday_greetings.infrastructure.JMAAdapter;
import it.xpug.kata.birthday_greetings.infrastructure.Sender;
import it.xpug.kata.birthday_greetings.infrastructure.SmtpServerConfiguration;
import it.xpug.kata.birthday_greetings.usecase.BirthdayService;

public class Main {

    public static void main(String[] args) {
        SmtpServerConfiguration smtpServerConfiguration = new SmtpServerConfiguration("localhost", 25);
        EmailApiAdapter emailApiAdapter = new JMAAdapter(smtpServerConfiguration);
        Sender emailSender = new EmailSender("sender@here.com", emailApiAdapter);
        EmployeeRepository employeeRepository = new EmployeeFileRepository("employee_data.txt");

        BirthdayService service = new BirthdayService(emailSender, employeeRepository);
        service.sendGreetings(new XDate());
    }

}

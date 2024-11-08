package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, MessagingException {
        Sender emailSender = new EmailSender("localhost", 25);
        BirthdayService service = new BirthdayService(emailSender);
        service.sendGreetings("employee_data.txt", new XDate());
    }

}

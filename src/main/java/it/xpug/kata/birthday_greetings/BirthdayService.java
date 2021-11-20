package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class BirthdayService {

    private final EmailProvider emailProvider;

    public BirthdayService(EmailProvider emailProvider) {
        this.emailProvider = emailProvider;
    }

    public void sendGreetings(String fileName, XDate xDate) throws IOException, ParseException, MessagingException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String str;
        removeHeader(in);
        while ((str = in.readLine()) != null) {
            String[] employeeData = str.split(", ");
            Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], new Email(emailProvider,employeeData[3]));
            if (employee.isBirthday(xDate)) {
                employee.sendEmailTo();
            }
        }
    }

    private void removeHeader(BufferedReader in) throws IOException {
        in.readLine();
    }

}

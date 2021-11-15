package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;

public class BirthdayService {
    private final EmailProvider emailProvider;
    private final String filename;

    public BirthdayService(EmailProvider emailProvider, String filename) {
        this.emailProvider = emailProvider;
        this.filename = filename;
    }

    public void sendGreetings(XDate xDate) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String str;
        in.readLine(); // skip header
        while ((str = in.readLine()) != null) {
            String[] employeeData = str.split(", ");
            Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
            if (employee.isBirthday(xDate)) {
                String recipient = employee.getEmail();
                String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
                String subject = "Happy Birthday!";
                emailProvider.sendMessage(subject, body, recipient);
            }
        }
    }


}

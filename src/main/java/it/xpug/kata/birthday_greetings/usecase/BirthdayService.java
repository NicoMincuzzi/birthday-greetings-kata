package it.xpug.kata.birthday_greetings.usecase;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.EmployeeRepository;
import it.xpug.kata.birthday_greetings.domain.XDate;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayService {

    private final EmployeeRepository employeeRepository;

    public BirthdayService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void sendGreetings(XDate xDate, String smtpHost, int smtpPort) throws MessagingException {
        List<Employee> birthdayEmployees = employeeRepository.readAll().stream()
                .filter(it -> it.isBirthday(xDate))
                .collect(Collectors.toList());

        for (Employee birthdayEmployee : birthdayEmployees) {
            String recipient = birthdayEmployee.getEmail();
            String body = "Happy Birthday, dear %NAME%".replace("%NAME%", birthdayEmployee.getFirstName().concat("!"));
            String subject = "Happy Birthday!";
            sendMessage(smtpHost, smtpPort, "sender@here.com", subject, body, recipient);
        }
    }

    private void sendMessage(String smtpHost, int smtpPort, String sender, String subject, String body, String recipient) throws MessagingException {
        // Create a mail session
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
        Session session = Session.getInstance(props, null);

        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(sender));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        msg.setSubject(subject);
        msg.setText(body);

        // Send the message
        Transport.send(msg);
    }
}

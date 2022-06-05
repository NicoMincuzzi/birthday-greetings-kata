package it.xpug.kata.birthday_greetings.domain;

import it.xpug.kata.birthday_greetings.infrastructure.BirthdayBodyFormatter;
import it.xpug.kata.birthday_greetings.infrastructure.BirthdaySubjectFormatter;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.text.ParseException;

import static javax.mail.Message.RecipientType.TO;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final XDate birthDate;
    private final Email email;

    public Employee(String firstName, String lastName, String birthDate, Email email) throws ParseException {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = new XDate(birthDate);
        this.email = email;
    }

    public boolean isBirthday(XDate today) {
        return today.isSameDay(birthDate);
    }

    public Message buildBirthdayGreeting(Session session) {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(email.sender());
            msg.setRecipient(TO, email.internetAddress());
            msg.setSubject(email.subject(new BirthdaySubjectFormatter()));
            msg.setText(email.body(new BirthdayBodyFormatter(), firstName));
            return msg;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Employee " + firstName + " " + lastName + " <" + email + "> born " + birthDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + birthDate.hashCode();
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (!birthDate.equals(other.birthDate))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            return other.lastName == null;
        } else return lastName.equals(other.lastName);
    }
}

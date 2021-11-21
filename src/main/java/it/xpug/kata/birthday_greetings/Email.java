package it.xpug.kata.birthday_greetings;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Objects;

import static javax.mail.Message.RecipientType.TO;

public class Email {
    private final String address;
    private final String subject;
    private String body;

    public Email(String address, String subject) {
        this.address = address;
        this.subject = subject;
    }

    public static Email birthdayGreetings(String address) {
        return new Email(address, "Happy Birthday!");
    }

    public void body(String firstName) {
        body = "Happy Birthday, dear %NAME%!".replace("%NAME%", firstName);
    }

    public Message message(Session session) throws Exception {
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("sender@here.com"));
        msg.setRecipient(TO, new InternetAddress(address));
        msg.setSubject(subject);
        msg.setText(body);
        return msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(address, email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}

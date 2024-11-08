package it.xpug.kata.birthday_greetings.domain;

public class BirthdayEmailFormatter implements MessageFormatter {

    @Override
    public String subject() {
        return "Happy Birthday!";
    }

    @Override
    public String body(String... values) {
        return "Happy Birthday, dear %NAME%!".replace("%NAME%", values[0]);
    }
}

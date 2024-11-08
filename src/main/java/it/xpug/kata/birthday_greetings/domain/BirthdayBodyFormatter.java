package it.xpug.kata.birthday_greetings.domain;

public class BirthdayBodyFormatter implements Formatter {
    @Override
    public String format(String... values) {
        return "Happy Birthday, dear %NAME%!".replace("%NAME%", values[0]);
    }
}

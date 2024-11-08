package it.xpug.kata.birthday_greetings.domain;

public class BirthdaySubjectFormatter implements Formatter {
    @Override
    public String format(String... values) {
        return "Happy Birthday!";
    }
}

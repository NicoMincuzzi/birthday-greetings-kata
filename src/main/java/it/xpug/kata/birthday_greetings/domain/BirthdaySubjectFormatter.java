package it.xpug.kata.birthday_greetings.domain;

public class BirthdaySubjectFormatter implements EmailFormatter {
    @Override
    public String format(String message) {
        return "Happy Birthday!";
    }
}

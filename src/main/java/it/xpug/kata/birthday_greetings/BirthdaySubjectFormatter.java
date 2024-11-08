package it.xpug.kata.birthday_greetings;

public class BirthdaySubjectFormatter implements Formatter {
    @Override
    public String format(String... values) {
        return "Happy Birthday!";
    }
}

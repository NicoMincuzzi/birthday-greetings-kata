package it.xpug.kata.birthday_greetings.domain;

public class BirthdayBodyFormatter implements EmailFormatter {
    @Override
    public String format(String message) {
        return "Happy Birthday, dear %NAME%".replace("%NAME%", message.concat("!"));
    }
}

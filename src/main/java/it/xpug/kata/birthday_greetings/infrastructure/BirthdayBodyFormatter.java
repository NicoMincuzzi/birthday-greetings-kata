package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.EmailFormatter;

public class BirthdayBodyFormatter implements EmailFormatter {
    @Override
    public String format(String message) {
        return "Happy Birthday, dear %NAME%".replace("%NAME%", message.concat("!"));
    }
}

package it.xpug.kata.birthday_greetings;

import java.text.ParseException;

public class EmployeeEntity {
    private final String birthDate;
    private final String lastName;
    private final String firstName;
    private final String email;

    public EmployeeEntity(String firstName, String lastName, String birthDate, String email) {
        this.birthDate = birthDate;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public Employee from() {
        try {
            return new Employee(firstName, lastName, birthDate, Email.birthdayGreetings(email));
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }
}

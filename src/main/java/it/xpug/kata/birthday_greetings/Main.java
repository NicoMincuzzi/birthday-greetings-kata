package it.xpug.kata.birthday_greetings;

public class Main {
    public static void main(String[] args) throws Exception {
        BirthdayService service = new BirthdayService();
        service.sendGreetings("employee_data.txt", new XDate(), "localhost", 25);
    }
}

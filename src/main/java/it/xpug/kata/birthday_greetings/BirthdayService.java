package it.xpug.kata.birthday_greetings;

public class BirthdayService {
    private final EmailProvider emailProvider;
    private final EmployeeRepository employeeRepository;

    public BirthdayService(EmailProvider emailProvider, EmployeeRepository employeeRepository) {
        this.emailProvider = emailProvider;
        this.employeeRepository = employeeRepository;
    }

    public void sendGreetings(XDate xDate) throws Exception {
        for (Employee employee : employeeRepository.retrieveEmployees()) {
            if (employee.isBirthday(xDate)) {
                String recipient = employee.getEmail();
                String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
                String subject = "Happy Birthday!";
                emailProvider.sendMessage(subject, body, recipient);
            }
        }
    }
}

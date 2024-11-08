package it.xpug.kata.birthday_greetings;

import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.infrastructure.EmailSender;
import it.xpug.kata.birthday_greetings.infrastructure.EmployeeFileRepository;
import it.xpug.kata.birthday_greetings.infrastructure.SmtpServerConfiguration;
import it.xpug.kata.birthday_greetings.usecase.BirthdayService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AcceptanceTest {

    private static final int NONSTANDARD_PORT = 9999;
    private BirthdayService birthdayService;
    private SimpleSmtpServer mailServer;

    @Before
    public void setUp() {
        mailServer = SimpleSmtpServer.start(NONSTANDARD_PORT);
        SmtpServerConfiguration smtpServerConfiguration = new SmtpServerConfiguration("localhost", NONSTANDARD_PORT);
        birthdayService = new BirthdayService(new EmailSender(smtpServerConfiguration, "sender@here.com"), new EmployeeFileRepository("employee_data.txt"));
    }

    @After
    public void tearDown() throws Exception {
        mailServer.stop();
        Thread.sleep(200);
    }

    @Test
    public void willSendGreetings_whenItsSomebodysBirthday() throws Exception {

        birthdayService.sendGreetings(new XDate("2008/10/08"));

        assertEquals("message not sent?", 1, mailServer.getReceivedEmailSize());
        SmtpMessage message = (SmtpMessage) mailServer.getReceivedEmail().next();
        assertEquals("Happy Birthday, dear John!", message.getBody());
        assertEquals("Happy Birthday!", message.getHeaderValue("Subject"));
        String[] recipients = message.getHeaderValues("To");
        assertEquals(1, recipients.length);
        assertEquals("john.doe@foobar.com", recipients[0].toString());
    }

    @Test
    public void willNotSendEmailsWhenNobodysBirthday() throws Exception {
        birthdayService.sendGreetings(new XDate("2008/01/01"));

        assertEquals("what? messages?", 0, mailServer.getReceivedEmailSize());
    }
}

package it.xpug.kata.birthday_greetings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class EmployeeTest {

    private final EmailProvider emailProvider = new EmailProvider("localhost", 9999);

    @Test
    public void testBirthday() throws Exception {
        Employee employee = new Employee("foo", "bar", "1990/01/31", new Email(emailProvider, "a@b.c"));
        assertFalse("not his birthday", employee.isBirthday(new XDate("2008/01/30")));
        assertTrue("his birthday", employee.isBirthday(new XDate("2008/01/31")));
    }

    @Test
    public void equality() throws Exception {
        Employee base = new Employee("First", "Last", "1999/09/01", new Email(emailProvider, "first@last.com"));
        Employee same = new Employee("First", "Last", "1999/09/01", new Email(emailProvider, "first@last.com"));
        Employee different = new Employee("First", "Last", "1999/09/01", new Email(emailProvider, "boom@boom.com"));

        assertFalse(base.equals(null));
        assertFalse(base.equals(""));
        assertTrue(base.equals(same));
        assertFalse(base.equals(different));
    }
}

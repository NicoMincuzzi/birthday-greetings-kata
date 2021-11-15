package it.xpug.kata.birthday_greetings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmployeeTest {

    @Test
    public void testBirthday() throws Exception {
        Employee employee = new Employee(new FileField("foo"), new FileField("bar"), new FileField("1990/01/31"), new FileField("a@b.c"));
        assertFalse("not his birthday", employee.isBirthday(new XDate("2008/01/30")));
        assertTrue("his birthday", employee.isBirthday(new XDate("2008/01/31")));
    }

    @Test
    public void equality() throws Exception {
        Employee base = new Employee(new FileField("First"), new FileField("Last"), new FileField("1999/09/01"), new FileField("first@last.com"));
        Employee same = new Employee(new FileField("First"), new FileField("Last"), new FileField("1999/09/01"), new FileField("first@last.com"));
        Employee different = new Employee(new FileField("First"), new FileField("Last"), new FileField("1999/09/01"), new FileField("boom@boom.com"));

        assertFalse(base.equals(null));
        assertFalse(base.equals(""));
        assertTrue(base.equals(same));
        assertFalse(base.equals(different));
    }
}

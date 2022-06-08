package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.EmployeeRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileRepository implements EmployeeRepository {
    private final String filename;

    public EmployeeFileRepository(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str;
            removeFileHeader(in);
            while ((str = in.readLine()) != null) {
                String[] employeeData = str.split(", ");
                employees.add(new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]));
            }
            return employees;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void removeFileHeader(BufferedReader in) throws IOException {
        in.readLine();
    }
}

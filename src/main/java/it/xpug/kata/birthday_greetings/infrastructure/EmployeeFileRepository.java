package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.EmployeeRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileRepository implements EmployeeRepository {

    private final String fileName;

    public EmployeeFileRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            removeHeader(in);
            String employee;
            while ((employee = in.readLine()) != null) {
                employees.add(Employee.from(employee));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    private void removeHeader(BufferedReader in) throws IOException {
        in.readLine();
    }

}

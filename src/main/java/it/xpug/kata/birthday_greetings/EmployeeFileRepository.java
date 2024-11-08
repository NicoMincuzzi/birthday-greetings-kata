package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
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
            String str = "";
            str = in.readLine(); // skip header
            while ((str = in.readLine()) != null) {
                String[] employeeData = str.split(", ");
                employees.add(Employee.from(employeeData));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

}

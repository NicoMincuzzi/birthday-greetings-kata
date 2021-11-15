package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeRepository {
    public static final int HEADERS = 1;
    private final String filename;

    public EmployeeRepository(String filename) {
        this.filename = filename;
    }

    public List<Employee> retrieveEmployees() throws Exception {
        List<Employee> employees = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(filename));
        for (String row : fileHeadersFilter(in).collect(Collectors.toList())) {
            String[] employeeData = row.split(", ");
            Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
            employees.add(employee);
        }
        return employees;
    }

    private Stream<String> fileHeadersFilter(BufferedReader in) {
        return in.lines().skip(HEADERS);
    }
}

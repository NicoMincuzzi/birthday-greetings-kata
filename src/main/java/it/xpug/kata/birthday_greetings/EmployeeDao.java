package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private final String filename;

    public EmployeeDao(String filename) {
        this.filename = filename;
    }

    public List<EmployeeEntity> readAll() {
        try {
            List<EmployeeEntity> employees = new ArrayList<>();
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str;
            removeHeader(in);
            while ((str = in.readLine()) != null) {
                String[] employeeData = str.split(", ");
                EmployeeEntity employee = new EmployeeEntity(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
                employees.add(employee);
            }
            return employees;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void removeHeader(BufferedReader in) throws IOException {
        in.readLine();
    }
}

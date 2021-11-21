package it.xpug.kata.birthday_greetings;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDao {

    private final File file;

    public EmployeeDao(File file) {
        this.file = file;
    }

    public List<EmployeeEntity> readAll() {
        return file.read().stream().map(row -> {
            String[] employeeData = row.split(", ");
            return new EmployeeEntity(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
        }).collect(Collectors.toList());
    }
}

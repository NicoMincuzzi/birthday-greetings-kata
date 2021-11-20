package it.xpug.kata.birthday_greetings;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class EmployeeRepository {

    private final EmployeeDao employeeDao;

    public EmployeeRepository(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> retrieveAll() {
        List<EmployeeEntity> employees = employeeDao.readAll();
        return employees.stream().map(EmployeeEntity::from).collect(toList());
    }
}

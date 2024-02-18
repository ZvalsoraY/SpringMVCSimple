package org.example.database;

import org.example.persons.Director;
import org.example.persons.Employee;
import org.example.persons.Level;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Database {
    public final List<Director> DIRECTORS = new ArrayList<>();
    public final List<Employee> EMPLOYEES = new ArrayList<>();

    public int LAST_DIRECTORS_ID = 0;
    public int LAST_EMPLOYEES_ID = 0;

    @PostConstruct
    void init() {
        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee1", Level.LOW));
        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee2", Level.LOW));
        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee3", Level.LOW));

        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee11", Level.MIDDLE));
        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee12", Level.MIDDLE));
        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee13", Level.MIDDLE));

        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee21", Level.HIGH));
        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee22", Level.HIGH));
        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee23", Level.HIGH));

        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee31", Level.TOP));
        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee32", Level.TOP));
        EMPLOYEES.add(new Employee(++LAST_EMPLOYEES_ID, "Employee33", Level.TOP));

        DIRECTORS.add(new Director(++LAST_DIRECTORS_ID, "Director1", "Department1", new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4))));
        DIRECTORS.add(new Director(++LAST_DIRECTORS_ID, "Director2", "Department2", new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
        DIRECTORS.add(new Director(++LAST_DIRECTORS_ID, "Director3", "Department3", new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6))));
    }
}

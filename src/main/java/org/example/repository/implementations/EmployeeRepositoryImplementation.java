package org.example.repository.implementations;

import lombok.AllArgsConstructor;
import org.example.database.Database;
import org.example.persons.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryImplementation implements EmployeeRepository {
    private final EmployeeRepository employeeRepository;
    private final Database database;

    @Override
    public List<Employee> findAll() {
    return database.EMPLOYEES;
    }
    @Override
    public Optional<Employee> findById(int id) {
        return database.EMPLOYEES.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }
    @Override
    public boolean delete(int id) {
        return database.EMPLOYEES.removeIf(item -> item.getId() == id);
    }

    @Override
    public void update(Employee employee) {
        database.EMPLOYEES.stream()
                .filter(item -> item.getId() == employee.getId())
                .findFirst()
                .ifPresent((editTask) -> database.EMPLOYEES.set(editTask.getId(), employee));
    }

    @Override
    public boolean create(Employee employee) {
        ++database.LAST_EMPLOYEES_ID;
        employee.setId(database.LAST_EMPLOYEES_ID);
        employee.setName(employee.getName());
        employee.setLevel(employee.getLevel());
        return database.EMPLOYEES.add(employee);
    }
}

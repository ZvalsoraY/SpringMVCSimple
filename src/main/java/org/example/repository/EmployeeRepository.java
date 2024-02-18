package org.example.repository;

import org.example.persons.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository {
    List<Employee> findAll();

    Optional<Employee> findById(int id);

    boolean delete(int id);

    void update(Employee employee);

    boolean create(Employee employee);
}

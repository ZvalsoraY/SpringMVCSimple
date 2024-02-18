package org.example.repository;

import org.example.persons.Director;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectorRepository {
    List<Director> findAll();

    Optional<Director> findById(int id);

    boolean delete(int id);

    void update(Director director);

    boolean create(Director director);
}

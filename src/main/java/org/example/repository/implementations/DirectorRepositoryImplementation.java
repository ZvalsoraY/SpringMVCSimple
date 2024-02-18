package org.example.repository.implementations;

import lombok.AllArgsConstructor;
import org.example.database.Database;
import org.example.persons.Director;
import org.example.repository.DirectorRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class DirectorRepositoryImplementation implements DirectorRepository {
    private final DirectorRepository directorRepository;
    private final Database database;

    @Override
    public List<Director> findAll() {
        return database.DIRECTORS;
    }
    @Override
    public Optional<Director> findById(int id) {
        return database.DIRECTORS.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }
    @Override
    public boolean delete(int id) {
        return database.DIRECTORS.removeIf(item -> item.getId() == id);
    }

    @Override
    public void update(Director director) {
        database.DIRECTORS.stream()
                .filter(item -> item.getId() == director.getId())
                .findFirst()
                .ifPresent((editTask) -> database.DIRECTORS.set(editTask.getId(), director));
    }

    @Override
    public boolean create(Director director) {
        ++database.LAST_DIRECTORS_ID;
        director.setId(database.LAST_DIRECTORS_ID);
        director.setName(director.getName());
        director.setDepartment(director.getDepartment());
        director.setEmployees(director.getEmployees());
        return database.DIRECTORS.add(director);
    }
}

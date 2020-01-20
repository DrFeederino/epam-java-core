package main.ru.epam.javacore.homework_6_repos_and_services.cargo.repo;

import main.ru.epam.javacore.homework_6_repos_and_services.cargo.domain.Cargo;

public interface CargoRepo {
    Cargo[] getAll();

    void add(Cargo cargo);

    void delete(long id);

    Cargo findById(long id);

    Cargo[] findByName(String name);

    void printAll();
}

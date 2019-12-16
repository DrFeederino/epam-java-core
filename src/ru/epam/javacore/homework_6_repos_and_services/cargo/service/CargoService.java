package ru.epam.javacore.homework_6_repos_and_services.cargo.service;

import ru.epam.javacore.homework_6_repos_and_services.cargo.domain.Cargo;

public interface CargoService {
    Cargo getAll();

    void add();

    void delete();

    Cargo findById();

    Cargo[] findByName();

    void printAll();

}

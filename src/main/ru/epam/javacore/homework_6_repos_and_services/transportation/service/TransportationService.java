package main.ru.epam.javacore.homework_6_repos_and_services.transportation.service;

import main.ru.epam.javacore.homework_6_repos_and_services.transportation.domain.Transportation;

public interface TransportationService {
    Transportation[] getAll();

    void add(Transportation transportation);

    void delete(long id);

    Transportation findById(long id);

    void printAll();
}

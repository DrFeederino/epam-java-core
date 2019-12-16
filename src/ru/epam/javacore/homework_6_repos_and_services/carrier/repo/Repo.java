package ru.epam.javacore.homework_6_repos_and_services.carrier.repo;

import ru.epam.javacore.homework_6_repos_and_services.carrier.domain.Carrier;

public interface Repo {
    Carrier[] get();

    void add(Carrier carrier);

    void delete(long id);

    Carrier findById(long id);

    Carrier[] findByName(String name);

    void printAll();
}

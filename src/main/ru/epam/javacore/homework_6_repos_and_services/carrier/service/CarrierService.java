package main.ru.epam.javacore.homework_6_repos_and_services.carrier.service;

import main.ru.epam.javacore.homework_6_repos_and_services.carrier.domain.Carrier;

public interface CarrierService {
    Carrier[] getAll();

    void add(Carrier carrier);

    void delete(long id);

    Carrier findById(long id);

    Carrier[] findByName(String name);

    void printAll();

}

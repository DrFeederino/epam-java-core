package ru.epam.javacore.homework_6_repos_and_services.transportation.service;

import ru.epam.javacore.homework_6_repos_and_services.transportation.domain.Transportation;

public class TransportationService implements Service {
    @Override
    public Transportation[] get() {
        return new Transportation[0];
    }

    @Override
    public void add(Transportation transportation) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Transportation findById(long id) {
        return null;
    }

    @Override
    public void printAll() {

    }
}

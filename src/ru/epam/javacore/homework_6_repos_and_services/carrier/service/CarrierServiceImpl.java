package ru.epam.javacore.homework_6_repos_and_services.carrier.service;

import ru.epam.javacore.homework_6_repos_and_services.carrier.domain.Carrier;

public class CarrierServiceImpl implements CarrierService {
    @Override
    public Carrier[] getAll() {
        return new Carrier[0];
    }

    @Override
    public void add(Carrier carrier) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Carrier findById(long id) {
        return null;
    }

    @Override
    public Carrier[] findByName(String name) {
        return new Carrier[0];
    }

    @Override
    public void printAll() {

    }
}

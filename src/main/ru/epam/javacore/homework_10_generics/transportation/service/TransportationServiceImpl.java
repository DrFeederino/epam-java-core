package main.ru.epam.javacore.homework_10_generics.transportation.service;

import main.ru.epam.javacore.homework_10_generics.transportation.domain.Transportation;
import main.ru.epam.javacore.homework_10_generics.transportation.repo.TransportationRepo;

import java.util.List;

public class TransportationServiceImpl implements TransportationService {

    private TransportationRepo transportationRepo;

    public TransportationServiceImpl(
            TransportationRepo transportationRepo) {
        this.transportationRepo = transportationRepo;
    }

    @Override
    public boolean deleteById(Long id) {
        return transportationRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        List<Transportation> allTransportations = transportationRepo.getAll();
        for (Transportation transportation : allTransportations) {
            System.out.println(transportation);
        }
    }

    @Override
    public void add(Transportation transportation) {
        transportationRepo.add(transportation);
    }

    @Override
    public Transportation getById(Long id) {
        return transportationRepo.getById(id);
    }

    @Override
    public List<Transportation> getAll() {
        return transportationRepo.getAll();
    }

    @Override
    public void update(Transportation transportation) {
        if (transportation != null) {
            transportationRepo.update(transportation);
        }
    }
}

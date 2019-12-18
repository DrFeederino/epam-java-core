package ru.epam.javacore.homework_7_arrays_and_lists.transportation.service.impl;

import ru.epam.javacore.homework_7_arrays_and_lists.transportation.domain.Transportation;
import ru.epam.javacore.homework_7_arrays_and_lists.transportation.repo.impl.TransportationArrayRepoImpl;
import ru.epam.javacore.homework_7_arrays_and_lists.transportation.repo.impl.TransportationCollectionRepoImpl;
import ru.epam.javacore.homework_7_arrays_and_lists.transportation.service.TransportationService;

public class TransportationServiceImpl implements TransportationService {
    private static final TransportationArrayRepoImpl transportationArrayRepo = new TransportationArrayRepoImpl();
    private static final TransportationCollectionRepoImpl transportationCollectionRepo = new TransportationCollectionRepoImpl();

    @Override
    public Transportation[] getAll() {
        Transportation[] transportations = transportationArrayRepo.getAll();
        if (transportations == null || transportations.length == 0) {
            transportations = transportationCollectionRepo.getAll();
        }
        return transportations;
    }

    @Override
    public void add(Transportation transportation) {
        transportationArrayRepo.add(transportation);
        transportationCollectionRepo.add(transportation);
    }

    @Override
    public boolean deleteById(Long id) {
        if (id == null) {
            return false;
        }
        return transportationCollectionRepo.deleteById(id) || transportationArrayRepo.deleteById(id);
    }

    @Override
    public Transportation getById(Long id) {
        if (id == null) {
            return null;
        }
        Transportation transportation = transportationArrayRepo.getById(id);
        if (transportation == null) {
            transportation = transportationCollectionRepo.getById(id);
        }
        return transportation;
    }

    @Override
    public void printAll() {
        Transportation[] transportations = getAll();
        for (Transportation transportation : transportations) {
            if (transportation != null) {
                System.out.println(transportation);
            }
        }
    }
}

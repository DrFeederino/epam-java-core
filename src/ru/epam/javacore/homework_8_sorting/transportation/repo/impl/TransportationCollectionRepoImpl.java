package ru.epam.javacore.homework_8_sorting.transportation.repo.impl;


import ru.epam.javacore.homework_8_sorting.storage.IdGenerator;
import ru.epam.javacore.homework_8_sorting.transportation.domain.Transportation;
import ru.epam.javacore.homework_8_sorting.transportation.repo.TransportationRepo;

import java.util.Iterator;
import java.util.List;

import static ru.epam.javacore.homework_8_sorting.storage.Storage.transportationCollection;

public class TransportationCollectionRepoImpl implements TransportationRepo {

    @Override
    public void add(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportationCollection.add(transportation);
    }

    @Override
    public void updateTransportation(Transportation transportation) {
        if (transportation != null && transportationCollection.contains(transportation)) {
            int idx = transportationCollection.indexOf(transportation);
            transportationCollection.set(idx, transportation);
        }
    }

    @Override
    public Transportation getById(long id) {
        for (Transportation transportation : transportationCollection) {
            if (Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }

        return null;
    }

    @Override
    public List<Transportation> getAll() {
        return transportationCollection;
    }

    @Override
    public boolean deleteById(long id) {
        boolean deleted = false;

        Iterator<Transportation> iter = transportationCollection.iterator();
        while (iter.hasNext()) {
            if (Long.valueOf(id).equals(iter.next().getId())) {
                iter.remove();
                deleted = true;
                break;
            }
        }
        return deleted;
    }
}

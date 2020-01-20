package main.ru.epam.javacore.homework_7_arrays_and_lists.transportation.repo.impl;

import main.ru.epam.javacore.homework_7_arrays_and_lists.storage.IdGenerator;
import main.ru.epam.javacore.homework_7_arrays_and_lists.transportation.domain.Transportation;
import main.ru.epam.javacore.homework_7_arrays_and_lists.transportation.repo.TransportationRepo;

import static main.ru.epam.javacore.homework_7_arrays_and_lists.storage.Storage.listOfTransportations;

public class TransportationCollectionRepoImpl implements TransportationRepo {
    @Override
    public Transportation[] getAll() {
        Transportation[] arrayOfTransportations = new Transportation[listOfTransportations.size()];
        arrayOfTransportations = listOfTransportations.toArray(arrayOfTransportations);
        return arrayOfTransportations;
    }

    @Override
    public void add(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        listOfTransportations.add(transportation);
    }

    @Override
    public boolean deleteById(long id) {
        for (Transportation transportation : listOfTransportations) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                listOfTransportations.remove(transportation);
                return true;
            }
        }
        return false;
    }

    @Override
    public Transportation getById(long id) {
        for (Transportation transportation : listOfTransportations) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }
        return null;
    }
}

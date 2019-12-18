package ru.epam.javacore.homework_7_arrays_and_lists.transportation.repo.impl;

import ru.epam.javacore.homework_7_arrays_and_lists.common.utils.ArrayUtils;
import ru.epam.javacore.homework_7_arrays_and_lists.storage.IdGenerator;
import ru.epam.javacore.homework_7_arrays_and_lists.transportation.domain.Transportation;
import ru.epam.javacore.homework_7_arrays_and_lists.transportation.repo.TransportationRepo;

import static ru.epam.javacore.homework_7_arrays_and_lists.storage.Storage.transportationIndex;
import static ru.epam.javacore.homework_7_arrays_and_lists.storage.Storage.transportations;

public class TransportationArrayRepoImpl implements TransportationRepo {
    @Override
    public Transportation[] getAll() {
        Transportation[] nonNullTransportations;
        int entries = 0;
        for (Transportation transportation : transportations) {
            if (transportation != null) {
                entries++;
            }
        }
        nonNullTransportations = new Transportation[entries];
        for (int i = 0, j = 0; i < transportations.length; i++) {
            Transportation transportation = transportations[i];
            if (transportation != null) {
                nonNullTransportations[j++] = transportation;
            }
        }
        return nonNullTransportations;
    }

    @Override
    public void add(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportations[transportationIndex] = transportation;
        transportationIndex++;

        if (transportationIndex == transportations.length) {
            Transportation[] newTransportations = new Transportation[transportations.length * 2];
            ArrayUtils.copyArray(transportations, newTransportations);
            transportations = newTransportations;
        }
    }

    @Override
    public boolean deleteById(long id) {
        Transportation[] newTransportations = new Transportation[transportations.length];
        boolean hasBeenDeleted = false;
        for (int i = 0, j = 0; i < transportations.length - 1; i++) {
            Transportation transportation = transportations[i];
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                transportationIndex--;
                hasBeenDeleted = true;
            } else {
                newTransportations[j++] = transportation;
            }
        }
        transportations = newTransportations;
        return hasBeenDeleted;
    }

    @Override
    public Transportation getById(long id) {
        for (Transportation transportation : transportations) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }
        return null;
    }
}

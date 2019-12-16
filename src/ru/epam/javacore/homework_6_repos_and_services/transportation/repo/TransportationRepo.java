package ru.epam.javacore.homework_6_repos_and_services.transportation.repo;

import ru.epam.javacore.homework_6_repos_and_services.common.utils.ArrayUtils;
import ru.epam.javacore.homework_6_repos_and_services.storage.IdGenerator;
import ru.epam.javacore.homework_6_repos_and_services.transportation.domain.Transportation;

import static ru.epam.javacore.homework_6_repos_and_services.storage.Storage.transportationIndex;
import static ru.epam.javacore.homework_6_repos_and_services.storage.Storage.transportations;

public class TransportationRepo implements Repo {
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
    public void delete(long id) {
        Transportation[] newTransportations = new Transportation[transportations.length];
        for (int i = 0, j = 0; i < transportations.length - 1; i++) {
            Transportation transportation = transportations[i];
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                transportationIndex--;
            } else {
                newTransportations[j++] = transportation;
            }
        }
        transportations = newTransportations;
    }

    @Override
    public Transportation findById(long id) {
        for (Transportation transportation : transportations) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }

        return null;
    }

    @Override
    public void printAll() {
        ArrayUtils.printArray(transportations);
    }
}

package main.ru.epam.javacore.homework_16_optional.transportation.repo.impl;


import main.ru.epam.javacore.homework_16_optional.storage.IdGenerator;
import main.ru.epam.javacore.homework_16_optional.transportation.domain.Transportation;
import main.ru.epam.javacore.homework_16_optional.transportation.repo.TransportationRepo;

import java.util.List;
import java.util.Optional;

import static main.ru.epam.javacore.homework_16_optional.storage.Storage.transportationCollection;

public class TransportationCollectionRepoImpl implements TransportationRepo {

    @Override
    public void save(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportationCollection.add(transportation);
    }

    @Override
    public Optional<Transportation> findById(Long id) {
        for (Transportation transportation : transportationCollection) {
            if (transportation.getId().equals(id)) {
                return Optional.ofNullable(transportation);
            }
        }

        return Optional.ofNullable(null);
    }

    @Override
    public List<Transportation> getAll() {
        return transportationCollection;
    }

    @Override
    public boolean update(Transportation transportation) {
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        return transportationCollection.removeIf(transportation -> id.equals(transportation.getId()));
    }

    @Override
    public int countAll() {
        return transportationCollection.size();
    }
}

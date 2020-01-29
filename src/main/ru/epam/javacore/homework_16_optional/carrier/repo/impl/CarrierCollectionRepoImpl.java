package main.ru.epam.javacore.homework_16_optional.carrier.repo.impl;


import main.ru.epam.javacore.homework_16_optional.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_16_optional.carrier.repo.CarrierRepo;
import main.ru.epam.javacore.homework_16_optional.storage.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static main.ru.epam.javacore.homework_16_optional.storage.Storage.carrierCollection;

public class CarrierCollectionRepoImpl implements CarrierRepo {

    @Override
    public void save(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carrierCollection.add(carrier);
    }

    @Override
    public Optional<Carrier> findById(Long id) {
        for (Carrier carrier : carrierCollection) {
            if (carrier.getId().equals(id)) {
                return Optional.ofNullable(carrier);
            }
        }

        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Carrier> getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Carrier[] findByName(String name) {
        List<Carrier> result = new ArrayList<>();

        for (Carrier carrier : carrierCollection) {
            if (Objects.equals(carrier.getName(), name)) {
                result.add(carrier);
            }
        }

        return result.toArray(new Carrier[0]);
    }

    @Override
    public boolean deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        return carrierCollection.removeIf(carrier -> id.equals(carrier.getId()));
    }

    @Override
    public List<Carrier> getAll() {
        return carrierCollection;
    }

    @Override
    public int countAll() {
        return carrierCollection.size();
    }

    @Override
    public boolean update(Carrier carrier) {
        return true;
    }

}

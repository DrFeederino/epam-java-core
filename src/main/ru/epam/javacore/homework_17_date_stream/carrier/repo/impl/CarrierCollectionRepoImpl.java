package main.ru.epam.javacore.homework_17_date_stream.carrier.repo.impl;


import main.ru.epam.javacore.homework_17_date_stream.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_17_date_stream.carrier.repo.CarrierRepo;
import main.ru.epam.javacore.homework_17_date_stream.storage.IdGenerator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static main.ru.epam.javacore.homework_17_date_stream.storage.Storage.carrierCollection;

public class CarrierCollectionRepoImpl implements CarrierRepo {

    @Override
    public void save(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carrierCollection.add(carrier);
    }

    @Override
    public Optional<Carrier> findById(Long id) {
        for (Carrier carrier : carrierCollection) {
            if (carrier != null && carrier.getId().equals(id)) {
                return Optional.of(carrier);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Carrier> getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Carrier[] findByName(String name) {
        return carrierCollection
                .stream()
                .filter(carrier -> Objects.equals(carrier.getName(), name))
                .collect(Collectors.toList())
                .toArray(Carrier[]::new);
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

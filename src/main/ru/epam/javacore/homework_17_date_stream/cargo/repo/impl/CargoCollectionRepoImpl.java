package main.ru.epam.javacore.homework_17_date_stream.cargo.repo.impl;


import main.ru.epam.javacore.homework_17_date_stream.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_17_date_stream.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_17_date_stream.common.solutions.utils.CollectionUtils;
import main.ru.epam.javacore.homework_17_date_stream.storage.IdGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static main.ru.epam.javacore.homework_17_date_stream.storage.Storage.cargoCollection;

public class CargoCollectionRepoImpl extends CommonCargoRepo {

    @Override
    public Optional<Cargo> getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Cargo[] findByName(String name) {
        return cargoCollection
                .stream()
                .filter(cargo -> Objects.equals(cargo.getName(), name))
                .collect(Collectors.toList())
                .toArray(Cargo[]::new);
    }

    @Override
    public List<Cargo> search(CargoSearchCondition searchCondition) {
        List<Cargo> cargos = getAll();

        if (CollectionUtils.isNotEmpty(cargos)) {
            if (searchCondition.needSorting()) {
                Comparator<Cargo> cargoComparator = createCargoComparator(searchCondition);
                cargos.sort(searchCondition.isAscOrdering() ? cargoComparator : cargoComparator.reversed());
            }
        }

        return cargos;
    }

    @Override
    public Optional<Cargo> findById(Long id) {
        for (Cargo cargo : cargoCollection) {
            if (cargo != null && id != null && id.equals(cargo.getId())) {
                return Optional.of(cargo);
            }
        }

        return Optional.empty();
    }

    @Override
    public void save(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargoCollection.add(cargo);
    }

    @Override
    public boolean update(Cargo entity) {
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        return cargoCollection.removeIf(cargo -> id.equals(cargo.getId()));
    }

    @Override
    public List<Cargo> getAll() {
        return cargoCollection;
    }

    @Override
    public int countAll() {
        return cargoCollection.size();
    }


}

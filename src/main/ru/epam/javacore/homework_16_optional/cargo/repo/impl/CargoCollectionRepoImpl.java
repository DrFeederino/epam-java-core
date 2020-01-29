package main.ru.epam.javacore.homework_16_optional.cargo.repo.impl;


import main.ru.epam.javacore.homework_16_optional.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_16_optional.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_16_optional.common.solutions.utils.CollectionUtils;
import main.ru.epam.javacore.homework_16_optional.storage.IdGenerator;

import java.util.*;

import static main.ru.epam.javacore.homework_16_optional.storage.Storage.cargoCollection;

public class CargoCollectionRepoImpl extends CommonCargoRepo {

    @Override
    public Optional<Cargo> getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Cargo[] findByName(String name) {
        List<Cargo> result = new ArrayList<>();

        for (Cargo carrier : cargoCollection) {
            if (Objects.equals(carrier.getName(), name)) {
                result.add(carrier);
            }
        }

        return result.toArray(new Cargo[0]);
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
            if (id != null && id.equals(cargo.getId())) {
                return Optional.ofNullable(cargo);
            }
        }

        return Optional.ofNullable(null);
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

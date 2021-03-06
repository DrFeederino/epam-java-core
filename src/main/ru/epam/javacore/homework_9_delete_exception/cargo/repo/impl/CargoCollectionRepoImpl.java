package main.ru.epam.javacore.homework_9_delete_exception.cargo.repo.impl;

import main.ru.epam.javacore.homework_9_delete_exception.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_9_delete_exception.cargo.repo.CargoRepo;
import main.ru.epam.javacore.homework_9_delete_exception.storage.IdGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static main.ru.epam.javacore.homework_9_delete_exception.storage.Storage.cargoCollection;

public class CargoCollectionRepoImpl implements CargoRepo {

    @Override
    public void updateCargo(Cargo cargo) {
        if (cargo != null && cargoCollection.contains(cargo)) {
            int idx = cargoCollection.indexOf(cargo);
            cargoCollection.set(idx, cargo);
        }
    }

    @Override
    public void add(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargoCollection.add(cargo);
    }

    @Override
    public Cargo getById(long id) {
        for (Cargo cargo : cargoCollection) {
            if (Long.valueOf(id).equals(cargo.getId())) {
                return cargo;
            }
        }

        return null;
    }

    @Override
    public Cargo[] getByName(String name) {
        List<Cargo> result = new ArrayList<>();

        for (Cargo carrier : cargoCollection) {
            if (Objects.equals(carrier.getName(), name)) {
                result.add(carrier);
            }
        }

        return result.toArray(new Cargo[0]);
    }

    @Override
    public List<Cargo> getAll() {
        return cargoCollection;
    }

    @Override
    public boolean deleteById(long id) {
        Iterator<Cargo> iter = cargoCollection.iterator();

        boolean removed = false;
        while (iter.hasNext()) {
            if (Long.valueOf(id).equals(iter.next().getId())) {
                iter.remove();
                removed = true;
                break;
            }
        }

        return removed;
    }
}

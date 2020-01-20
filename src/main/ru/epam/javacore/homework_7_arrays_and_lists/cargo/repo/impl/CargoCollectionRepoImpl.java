package main.ru.epam.javacore.homework_7_arrays_and_lists.cargo.repo.impl;

import main.ru.epam.javacore.homework_7_arrays_and_lists.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_7_arrays_and_lists.cargo.repo.CargoRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static main.ru.epam.javacore.homework_7_arrays_and_lists.storage.Storage.listOfCargos;

public class CargoCollectionRepoImpl implements CargoRepo {
    @Override
    public Cargo[] getAll() {
        Cargo[] arrayOfCargos = new Cargo[listOfCargos.size()];
        arrayOfCargos = listOfCargos.toArray(arrayOfCargos);
        return arrayOfCargos;
    }

    @Override
    public void add(Cargo cargo) {
        listOfCargos.add(cargo);
    }

    @Override
    public Cargo getById(long id) {
        for (Cargo cargo : listOfCargos) {
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                return cargo;
            }
        }
        return null;
    }

    @Override
    public Cargo[] getByName(String name) {
        List<Cargo> cargos = new ArrayList<>();
        for (Cargo cargo : listOfCargos) {
            if (cargo != null && Objects.equals(cargo.getName(), name)) {
                cargos.add(cargo);
            }
        }
        Cargo[] arrayOfCargos = new Cargo[cargos.size()];
        arrayOfCargos = cargos.toArray(arrayOfCargos);
        return arrayOfCargos;
    }

    @Override
    public boolean deleteById(long id) {
        for (Cargo cargo : listOfCargos) {
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                listOfCargos.remove(cargo);
                return true;
            }
        }
        return false;
    }
}

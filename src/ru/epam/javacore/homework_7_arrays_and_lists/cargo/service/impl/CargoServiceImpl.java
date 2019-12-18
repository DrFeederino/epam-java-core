package ru.epam.javacore.homework_7_arrays_and_lists.cargo.service.impl;

import ru.epam.javacore.homework_7_arrays_and_lists.cargo.domain.Cargo;
import ru.epam.javacore.homework_7_arrays_and_lists.cargo.repo.impl.CargoArrayRepoImpl;
import ru.epam.javacore.homework_7_arrays_and_lists.cargo.repo.impl.CargoCollectionRepoImpl;
import ru.epam.javacore.homework_7_arrays_and_lists.cargo.service.CargoService;

public class CargoServiceImpl implements CargoService {
    private static final CargoArrayRepoImpl cargoArrayRepo = new CargoArrayRepoImpl();
    private static final CargoCollectionRepoImpl cargoCollectionRepo = new CargoCollectionRepoImpl();

    @Override
    public Cargo[] getAll() {
        Cargo[] cargos = cargoArrayRepo.getAll();
        if (cargos == null || cargos.length == 0) {
            cargos = cargoCollectionRepo.getAll();
        }
        return cargos;
    }

    @Override
    public void add(Cargo cargo) {
        cargoArrayRepo.add(cargo);
        cargoCollectionRepo.add(cargo);
    }

    @Override
    public Cargo getById(Long id) {
        if (id == null) {
            return null;
        } else {
            Cargo cargo = cargoArrayRepo.getById(id);
            if (cargo == null) {
                cargo = cargoCollectionRepo.getById(id);
            }
            return cargo;
        }
    }

    @Override
    public Cargo[] getByName(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        } else {
            Cargo[] cargosByName = cargoArrayRepo.getByName(name);
            if (cargosByName == null || cargosByName.length == 0) {
                cargosByName = cargoCollectionRepo.getByName(name);
            }
            return cargosByName;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if (id == null) {
            return false;
        }
        return cargoArrayRepo.deleteById(id) || cargoCollectionRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        Cargo[] cargos = getAll();
        for (Cargo cargo : cargos) {
            if (cargo != null) {
                System.out.println(cargo);
            }
        }
    }
}

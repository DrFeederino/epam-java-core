package ru.epam.javacore.homework_7_arrays_and_lists.cargo.repo.impl;

import ru.epam.javacore.homework_7_arrays_and_lists.cargo.domain.Cargo;
import ru.epam.javacore.homework_7_arrays_and_lists.cargo.repo.CargoRepo;
import ru.epam.javacore.homework_7_arrays_and_lists.common.utils.ArrayUtils;
import ru.epam.javacore.homework_7_arrays_and_lists.storage.IdGenerator;

import java.util.Objects;

import static ru.epam.javacore.homework_7_arrays_and_lists.storage.Storage.cargoIndex;
import static ru.epam.javacore.homework_7_arrays_and_lists.storage.Storage.cargos;

public class CargoArrayRepoImpl implements CargoRepo {
    @Override
    public Cargo[] getAll() {
        Cargo[] nonNullCargos;
        int entries = 0;
        for (Cargo cargo : cargos) {
            if (cargo != null) {
                entries++;
            }
        }
        nonNullCargos = new Cargo[entries];
        for (int i = 0, j = 0; i < cargos.length; i++) {
            Cargo cargo = cargos[i];
            if (cargo != null) {
                nonNullCargos[j++] = cargo;
            }
        }
        return nonNullCargos;
    }

    @Override
    public void add(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargos[cargoIndex++] = cargo;
        if (cargoIndex == cargos.length) {
            Cargo[] newCargos = new Cargo[cargos.length * 2];
            ArrayUtils.copyArray(cargos, newCargos);
            cargos = newCargos;
        }
    }

    @Override
    public boolean deleteById(long id) {
        Cargo[] newCargos = new Cargo[cargos.length];
        boolean hasBeenDeleted = false;
        for (int i = 0, j = 0; i < cargos.length - 1; i++) {
            Cargo cargo = cargos[i];
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                cargoIndex--;
                hasBeenDeleted = true;
            } else {
                newCargos[j++] = cargo;
            }
        }
        cargos = newCargos;
        return hasBeenDeleted;
    }

    @Override
    public Cargo getById(long id) {
        for (Cargo cargo : cargos) {
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                return cargo;
            }
        }
        return null;
    }

    @Override
    public Cargo[] getByName(String name) {
        Cargo[] result = new Cargo[cargos.length];

        int curIndex = 0;
        for (Cargo cargo : cargos) {
            if (cargo != null && Objects.equals(cargo.getName(), name)) {
                result[curIndex++] = cargo;
            }
        }
        Cargo[] trimmedResult = new Cargo[curIndex];
        ArrayUtils.copyOfRangeArray(result, trimmedResult, curIndex);
        return trimmedResult;
    }
}

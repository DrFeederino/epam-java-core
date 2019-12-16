package ru.epam.javacore.homework_6_repos_and_services.cargo.repo;

import ru.epam.javacore.homework_6_repos_and_services.cargo.domain.Cargo;
import ru.epam.javacore.homework_6_repos_and_services.common.utils.ArrayUtils;
import ru.epam.javacore.homework_6_repos_and_services.storage.IdGenerator;

import java.util.Objects;

import static ru.epam.javacore.homework_6_repos_and_services.storage.Storage.cargoIndex;
import static ru.epam.javacore.homework_6_repos_and_services.storage.Storage.cargos;

public class CargoRepo implements Repo {

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
    public void delete(long id) {
        Cargo[] newCargos = new Cargo[cargos.length];
        for (int i = 0, j = 0; i < cargos.length - 1; i++) {
            Cargo cargo = cargos[i];
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                cargoIndex--;
            } else {
                newCargos[j++] = cargo;
            }
        }
        cargos = newCargos;
    }

    @Override
    public Cargo findById(long id) {
        for (Cargo cargo : cargos) {
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                return cargo;
            }
        }
        return null;
    }

    @Override
    public Cargo[] findByName(String name) {
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

    @Override
    public void printAll() {
        ArrayUtils.printArray(cargos);
    }
}

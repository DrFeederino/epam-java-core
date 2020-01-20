package main.ru.epam.javacore.homework_9_delete_exception.cargo.repo.impl;


import main.ru.epam.javacore.homework_9_delete_exception.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_9_delete_exception.cargo.repo.CargoRepo;
import main.ru.epam.javacore.homework_9_delete_exception.common.solutions.utils.ArrayUtils;
import main.ru.epam.javacore.homework_9_delete_exception.storage.IdGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static main.ru.epam.javacore.homework_9_delete_exception.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static main.ru.epam.javacore.homework_9_delete_exception.storage.Storage.cargoArray;
import static main.ru.epam.javacore.homework_9_delete_exception.storage.Storage.cargoIndex;

public class CargoArrayRepoImpl implements CargoRepo {

    private static final Cargo[] EMPTY_CARGO_ARRAY = new Cargo[0];

    @Override
    public void updateCargo(Cargo cargo) {
        if (cargo != null) {
            for (Cargo cargoFromArr : cargoArray) {
                if (cargoFromArr != null && Long.valueOf(cargoFromArr.getId()).equals(cargo.getId())) {
                    cargoFromArr = cargo;
                    break;
                }
            }
        }
    }

    @Override
    public void add(Cargo cargo) {
        if (cargoIndex == cargoArray.length) {
            Cargo[] newCargos = new Cargo[cargoArray.length * 2];
            ArrayUtils.copyArray(cargoArray, newCargos);
            cargoArray = newCargos;
        }

        cargo.setId(IdGenerator.generateId());
        cargoArray[cargoIndex] = cargo;
        cargoIndex++;
    }

    @Override
    public Cargo getById(long id) {
        for (Cargo cargo : cargoArray) {
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                return cargo;
            }
        }

        return null;
    }

    @Override
    public Cargo[] getByName(String name) {
        Cargo[] searchResultWithNullableElems = getByNameIncludingNullElements(name);
        if (searchResultWithNullableElems == null
                || searchResultWithNullableElems.length == 0) {
            return EMPTY_CARGO_ARRAY;
        } else {
            return excludeNullableElementsFromArray(searchResultWithNullableElems);
        }
    }

    private Cargo[] getByNameIncludingNullElements(String name) {
        Cargo[] result = new Cargo[cargoArray.length];

        int curIndex = 0;
        for (Cargo carrier : cargoArray) {
            if (carrier != null && Objects.equals(carrier.getName(), name)) {
                result[curIndex++] = carrier;
            }
        }

        return result;
    }

    /**
     * [A,B,C, null, null] [A,B,C, null, null, null, D] [A,B,C]
     * <p>
     * new String[3]
     */
    private Cargo[] excludeNullableElementsFromArray(Cargo[] cargos) {
        int sizeOfArrWithNotNullElems = 0;

        for (Cargo cargo : cargos) {
            if (cargo != null) {
                sizeOfArrWithNotNullElems++;
            }
        }

        if (sizeOfArrWithNotNullElems == 0) {
            return EMPTY_CARGO_ARRAY;
        } else {
            Cargo[] result = new Cargo[sizeOfArrWithNotNullElems];
            int index = 0;
            for (Cargo cargo : cargos) {
                if (cargo != null) {
                    result[index++] = cargo;
                }
            }

            return result;
        }
    }

    @Override
    public boolean deleteById(long id) {
        Integer indexToDelete = findEntityIndexInArrayStorageById(cargoArray, id);

        if (indexToDelete == null) {
            return false;
        } else {
            ArrayUtils.removeElement(cargoArray, indexToDelete);
            return true;
        }
    }

    @Override
    public List<Cargo> getAll() {
        return Arrays.asList(cargoArray);
    }
}

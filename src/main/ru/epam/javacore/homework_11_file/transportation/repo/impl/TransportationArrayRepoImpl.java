package main.ru.epam.javacore.homework_11_file.transportation.repo.impl;


import main.ru.epam.javacore.homework_11_file.common.solutions.utils.ArrayUtils;
import main.ru.epam.javacore.homework_11_file.storage.IdGenerator;
import main.ru.epam.javacore.homework_11_file.transportation.domain.Transportation;
import main.ru.epam.javacore.homework_11_file.transportation.repo.TransportationRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static main.ru.epam.javacore.homework_11_file.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static main.ru.epam.javacore.homework_11_file.storage.Storage.transportationArray;
import static main.ru.epam.javacore.homework_11_file.storage.Storage.transportationIndex;

public class TransportationArrayRepoImpl implements TransportationRepo {

    private static final Transportation[] EMPTY_TRANSPORTATION_ARRAY = new Transportation[0];

    @Override
    public void save(Transportation transportation) {
        if (transportationIndex == transportationArray.length) {
            Transportation[] newTransportations =
                    new Transportation[transportationArray.length * 2];
            ArrayUtils.copyArray(transportationArray, newTransportations);
            transportationArray = newTransportations;
        }

        transportation.setId(IdGenerator.generateId());
        transportationArray[transportationIndex] = transportation;
        transportationIndex++;
    }

    @Override
    public Transportation findById(Long id) {
        for (Transportation transportation : transportationArray) {
            if (transportation != null && transportation.getId().equals(id)) {
                return transportation;
            }
        }

        return null;
    }

    @Override
    public List<Transportation> getAll() {
        Transportation[] transportations = excludeNullableElementsFromArray(transportationArray);
        return transportations.length == 0 ? Collections.emptyList()
                : Arrays.asList(transportationArray);
    }

    @Override
    public int countAll() {
        return getAll().size();
    }

    private Transportation[] excludeNullableElementsFromArray(Transportation[] transportations) {
        int sizeOfArrWithNotNullElems = 0;

        for (Transportation transportation : transportations) {
            if (transportation != null) {
                sizeOfArrWithNotNullElems++;
            }
        }

        if (sizeOfArrWithNotNullElems == 0) {
            return EMPTY_TRANSPORTATION_ARRAY;
        } else {
            Transportation[] result = new Transportation[sizeOfArrWithNotNullElems];
            int index = 0;
            for (Transportation transportation : transportations) {
                if (transportation != null) {
                    result[index++] = transportation;
                }
            }

            return result;
        }
    }


    @Override
    public boolean update(Transportation transportation) {
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        Integer indexToDelete = findEntityIndexInArrayStorageById(transportationArray, id);

        if (indexToDelete == null) {
            return false;
        } else {
            ArrayUtils.removeElement(transportationArray, indexToDelete);
            return true;
        }
    }
}

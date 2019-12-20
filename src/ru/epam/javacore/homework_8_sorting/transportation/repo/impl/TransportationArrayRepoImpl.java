package ru.epam.javacore.homework_8_sorting.transportation.repo.impl;


import ru.epam.javacore.homework_8_sorting.common.solutions.utils.ArrayUtils;
import ru.epam.javacore.homework_8_sorting.storage.IdGenerator;
import ru.epam.javacore.homework_8_sorting.transportation.domain.Transportation;
import ru.epam.javacore.homework_8_sorting.transportation.repo.TransportationRepo;

import java.util.Arrays;
import java.util.List;

import static ru.epam.javacore.homework_8_sorting.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static ru.epam.javacore.homework_8_sorting.storage.Storage.transportationArray;
import static ru.epam.javacore.homework_8_sorting.storage.Storage.transportationIndex;

public class TransportationArrayRepoImpl implements TransportationRepo {

    @Override
    public void add(Transportation transportation) {
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
    public void updateTransportation(Transportation transportation) {
        if (transportation != null) {
            for (Transportation transportationFromArr : transportationArray) {
                if (transportationFromArr != null && Long.valueOf(transportationFromArr.getId()).equals(transportationFromArr.getId())) {
                    transportationFromArr = transportation;
                    break;
                }
            }
        }
    }

    @Override
    public Transportation getById(long id) {
        for (Transportation transportation : transportationArray) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }

        return null;
    }

    @Override
    public List<Transportation> getAll() {
        return Arrays.asList(transportationArray);
    }

    @Override
    public boolean deleteById(long id) {
        Integer indexToDelete = findEntityIndexInArrayStorageById(transportationArray, id);

        if (indexToDelete == null) {
            return false;
        } else {
            ArrayUtils.removeElement(transportationArray, indexToDelete);
            return true;
        }
    }
}

package ru.epam.javacore.homework_7_arrays_and_lists.carrier.repo.impl;

import ru.epam.javacore.homework_7_arrays_and_lists.carrier.domain.Carrier;
import ru.epam.javacore.homework_7_arrays_and_lists.carrier.repo.CarrierRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ru.epam.javacore.homework_7_arrays_and_lists.storage.Storage.listOfCarriers;

public class CarrierCollectionRepoImpl implements CarrierRepo {
    @Override
    public Carrier[] getAll() {
        Carrier[] arrayOfCarriers = new Carrier[listOfCarriers.size()];
        arrayOfCarriers = listOfCarriers.toArray(arrayOfCarriers);
        return arrayOfCarriers;
    }

    @Override
    public void add(Carrier carrier) {
        listOfCarriers.add(carrier);

    }

    @Override
    public Carrier getById(long id) {
        for (Carrier carrier : listOfCarriers) {
            if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
                return carrier;
            }
        }
        return null;
    }

    @Override
    public Carrier[] getByName(String name) {
        List<Carrier> carriers = new ArrayList<>();
        for (Carrier carrier : listOfCarriers) {
            if (carrier != null && Objects.equals(carrier.getName(), name)) {
                carriers.add(carrier);
            }
        }
        Carrier[] arrayOfCarriers = new Carrier[carriers.size()];
        arrayOfCarriers = carriers.toArray(arrayOfCarriers);
        return arrayOfCarriers;
    }

    @Override
    public boolean deleteById(long id) {
        for (Carrier carrier : listOfCarriers) {
            if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
                listOfCarriers.remove(carrier);
                return true;
            }
        }
        return false;
    }
}

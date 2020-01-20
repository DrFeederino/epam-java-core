package main.ru.epam.javacore.homework_9_delete_exception.carrier.repo.impl;

import main.ru.epam.javacore.homework_9_delete_exception.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_9_delete_exception.carrier.repo.CarrierRepo;
import main.ru.epam.javacore.homework_9_delete_exception.storage.IdGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static main.ru.epam.javacore.homework_9_delete_exception.storage.Storage.carrierCollection;

public class CarrierCollectionRepoImpl implements CarrierRepo {

    @Override
    public void add(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carrierCollection.add(carrier);
    }

    @Override
    public void updateCarrier(Carrier carrier) {
        if (carrier != null && carrierCollection.contains(carrier)) {
            int idx = carrierCollection.indexOf(carrier);
            carrierCollection.set(idx, carrier);
        }
    }

    @Override
    public Carrier getById(long id) {
        for (Carrier carrier : carrierCollection) {
            if (Long.valueOf(id).equals(carrier.getId())) {
                return carrier;
            }
        }

        return null;
    }

    @Override
    public Carrier[] getByName(String name) {
        List<Carrier> result = new ArrayList<>();

        for (Carrier carrier : carrierCollection) {
            if (Objects.equals(carrier.getName(), name)) {
                result.add(carrier);
            }
        }

        return result.toArray(new Carrier[0]);
    }

    @Override
    public boolean deleteById(long id) {
        Iterator<Carrier> iter = carrierCollection.iterator();

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

    @Override
    public List<Carrier> getAll() {
        return carrierCollection;
    }
}

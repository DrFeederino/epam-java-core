package ru.epam.javacore.homework_7_arrays_and_lists.carrier.service.impl;

import ru.epam.javacore.homework_7_arrays_and_lists.carrier.domain.Carrier;
import ru.epam.javacore.homework_7_arrays_and_lists.carrier.repo.impl.CarrierArrayRepoImpl;
import ru.epam.javacore.homework_7_arrays_and_lists.carrier.repo.impl.CarrierCollectionRepoImpl;
import ru.epam.javacore.homework_7_arrays_and_lists.carrier.service.CarrierService;

public class CarrierServiceImpl implements CarrierService {
    private static final CarrierCollectionRepoImpl carrierCollectionRepo = new CarrierCollectionRepoImpl();
    private static final CarrierArrayRepoImpl carrierArrayRepo = new CarrierArrayRepoImpl();

    @Override
    public Carrier[] getAll() {
        Carrier[] carriers = carrierArrayRepo.getAll();
        if (carriers == null || carriers.length == 0) {
            carriers = carrierCollectionRepo.getAll();
        }
        return carriers;
    }

    @Override
    public void add(Carrier carrier) {
        carrierArrayRepo.add(carrier);
        carrierCollectionRepo.add(carrier);
    }

    @Override
    public Carrier getById(Long id) {
        if (id == null) {
            return null;
        }
        Carrier carrier = carrierArrayRepo.getById(id);
        if (carrier == null) {
            carrier = carrierCollectionRepo.getById(id);
        }
        return carrier;
    }

    @Override
    public Carrier[] getByName(String name) {
        Carrier[] carriersByName = carrierArrayRepo.getByName(name);
        if (carriersByName == null || carriersByName.length == 0) {
            carriersByName = carrierCollectionRepo.getByName(name);
        }
        return carriersByName;
    }

    @Override
    public boolean deleteById(Long id) {
        if (id == null) {
            return false;
        }
        return carrierCollectionRepo.deleteById(id) || carrierArrayRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        Carrier[] carriers = getAll();
        for (Carrier carrier : carriers) {
            if (carrier != null) {
                System.out.println(carrier);
            }
        }
    }
}

package main.ru.epam.javacore.homework_8_sorting.carrier.service;

import main.ru.epam.javacore.homework_8_sorting.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_8_sorting.carrier.repo.CarrierRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarrierServiceImpl implements CarrierService {

    private CarrierRepo carrierRepo;

    public CarrierServiceImpl(
            CarrierRepo carrierRepo) {
        this.carrierRepo = carrierRepo;
    }

    @Override
    public void add(Carrier carrier) {
        carrierRepo.add(carrier);
    }

    @Override
    public void updateCarrier(Carrier carrier) {
        carrierRepo.updateCarrier(carrier);
    }

    @Override
    public Carrier getById(Long id) {
        if (id != null) {
            return carrierRepo.getById(id);
        }
        return null;
    }

    @Override
    public List<Carrier> getByName(String name) {
        Carrier[] found = carrierRepo.getByName(name);
        return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);

    }

    @Override
    public List<Carrier> getAll() {
        return carrierRepo.getAll();
    }

    @Override
    public boolean deleteById(Long id) {
        return carrierRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        List<Carrier> carriers = carrierRepo.getAll();
        for (Carrier carrier : carriers) {
            System.out.println(carrier);
        }
    }
}

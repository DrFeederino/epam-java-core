package main.ru.epam.javacore.homework_16_optional.carrier.service;

import main.ru.epam.javacore.homework_16_optional.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_16_optional.carrier.exception.unchecked.CarrierDeleteConstraintViolationException;
import main.ru.epam.javacore.homework_16_optional.carrier.repo.CarrierRepo;
import main.ru.epam.javacore.homework_16_optional.transportation.domain.Transportation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CarrierServiceImpl implements CarrierService {

    private CarrierRepo carrierRepo;

    public CarrierServiceImpl(
            CarrierRepo carrierRepo) {
        this.carrierRepo = carrierRepo;
    }

    @Override
    public void save(Carrier carrier) {
        carrierRepo.save(carrier);
    }

    @Override
    public Optional<Carrier> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return carrierRepo.findById(id);
    }

    @Override
    public Optional<Carrier> getByIdFetchingTransportations(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return carrierRepo.getByIdFetchingTransportations(id);
    }

    @Override
    public List<Carrier> findByName(String name) {
        Carrier[] found = carrierRepo.findByName(name);

        return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);
    }

    @Override
    public List<Carrier> getAll() {
        return carrierRepo.getAll();
    }

    @Override
    public int countAll() {
        return this.carrierRepo.countAll();
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Carrier> carrier = this.getByIdFetchingTransportations(id);

        if (carrier.isPresent()) {
            List<Transportation> transportations = carrier.get().getTransportations();
            boolean hasTransportations = transportations != null && transportations.size() > 0;
            if (hasTransportations) {
                throw new CarrierDeleteConstraintViolationException(id);
            }

            return carrierRepo.deleteById(id);
        } else {
            return false;
        }
    }

    @Override
    public void printAll() {
        List<Carrier> carriers = carrierRepo.getAll();
        for (Carrier carrier : carriers) {
            System.out.println(carrier);
        }
    }

    @Override
    public boolean update(Carrier carrier) {
        if (carrier != null) {
            carrierRepo.update(carrier);
        }

        return false;
    }
}

package ru.epam.javacore.homework_8_sorting.carrier.repo;

import ru.epam.javacore.homework_8_sorting.carrier.domain.Carrier;
import ru.epam.javacore.homework_8_sorting.common.business.repo.CommonRepo;

import java.util.List;

public interface CarrierRepo extends CommonRepo {

    void add(Carrier carrier);

    void updateCarrier(Carrier cargo);

    Carrier getById(long id);

    Carrier[] getByName(String name);

    List<Carrier> getAll();
}

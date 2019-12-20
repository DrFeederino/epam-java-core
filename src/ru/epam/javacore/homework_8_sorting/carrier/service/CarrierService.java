package ru.epam.javacore.homework_8_sorting.carrier.service;

import ru.epam.javacore.homework_8_sorting.carrier.domain.Carrier;
import ru.epam.javacore.homework_8_sorting.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService {
    void add(Carrier carrier);

    void updateCarrier(Carrier carrier);

    Carrier getById(Long id);

    List<Carrier> getByName(String name);

    List<Carrier> getAll();

}

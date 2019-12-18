package ru.epam.javacore.homework_7_arrays_and_lists.carrier.service;

import ru.epam.javacore.homework_7_arrays_and_lists.carrier.domain.Carrier;
import ru.epam.javacore.homework_7_arrays_and_lists.common.business.service.CommonService;

public interface CarrierService extends CommonService {
    Carrier[] getAll();

    void add(Carrier carrier);

    Carrier getById(Long id);

    Carrier[] getByName(String name);
}

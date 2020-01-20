package main.ru.epam.javacore.homework_9_delete_exception.carrier.service;

import main.ru.epam.javacore.homework_9_delete_exception.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_9_delete_exception.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService {
    void add(Carrier carrier);

    void updateCarrier(Carrier carrier);

    Carrier getById(Long id);

    List<Carrier> getByName(String name);

    List<Carrier> getAll();

}

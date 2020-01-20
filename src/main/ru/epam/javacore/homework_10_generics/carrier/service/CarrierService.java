package main.ru.epam.javacore.homework_10_generics.carrier.service;

import main.ru.epam.javacore.homework_10_generics.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_10_generics.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService<Carrier> {
    void add(Carrier carrier);

    Carrier getById(Long id);

    Carrier getByIdFetchingTransportations(Long id);

    List<Carrier> findByName(String name);

    List<Carrier> getAll();

    void update(Carrier carrier);

}

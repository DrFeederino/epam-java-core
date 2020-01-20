package main.ru.epam.javacore.homework_13_sax.carrier.service;

import main.ru.epam.javacore.homework_13_sax.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_13_sax.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long> {

    Carrier getByIdFetchingTransportations(Long id);

    List<Carrier> findByName(String name);

}

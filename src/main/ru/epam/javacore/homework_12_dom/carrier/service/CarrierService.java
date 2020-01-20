package main.ru.epam.javacore.homework_12_dom.carrier.service;

import main.ru.epam.javacore.homework_12_dom.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_12_dom.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long> {

    Carrier getByIdFetchingTransportations(Long id);

    List<Carrier> findByName(String name);

}

package ru.epam.javacore.homework_11_file.carrier.service;

import ru.epam.javacore.homework_11_file.carrier.domain.Carrier;
import ru.epam.javacore.homework_11_file.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long> {

    Carrier getByIdFetchingTransportations(Long id);

    List<Carrier> findByName(String name);

}
package main.ru.epam.javacore.homework_17_date_stream.carrier.service;

import main.ru.epam.javacore.homework_17_date_stream.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_17_date_stream.common.business.service.CommonService;

import java.util.List;
import java.util.Optional;

public interface CarrierService extends CommonService<Carrier, Long> {

    Optional<Carrier> getByIdFetchingTransportations(Long id);

    List<Carrier> findByName(String name);

}

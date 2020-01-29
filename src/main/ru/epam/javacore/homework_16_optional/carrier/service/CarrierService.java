package main.ru.epam.javacore.homework_16_optional.carrier.service;

import main.ru.epam.javacore.homework_16_optional.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_16_optional.common.business.service.CommonService;

import java.util.List;
import java.util.Optional;

public interface CarrierService extends CommonService<Carrier, Long> {

    Optional<Carrier> getByIdFetchingTransportations(Long id);

    List<Carrier> findByName(String name);

}

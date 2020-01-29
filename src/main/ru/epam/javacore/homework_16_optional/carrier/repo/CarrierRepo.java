package main.ru.epam.javacore.homework_16_optional.carrier.repo;

import main.ru.epam.javacore.homework_16_optional.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_16_optional.common.business.repo.CommonRepo;

import java.util.Optional;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    Optional<Carrier> getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

}

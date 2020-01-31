package main.ru.epam.javacore.homework_17_date_stream.carrier.repo;

import main.ru.epam.javacore.homework_17_date_stream.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_17_date_stream.common.business.repo.CommonRepo;

import java.util.Optional;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    Optional<Carrier> getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

}

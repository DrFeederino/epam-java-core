package ru.epam.javacore.homework_13_sax.carrier.repo;

import ru.epam.javacore.homework_13_sax.carrier.domain.Carrier;
import ru.epam.javacore.homework_13_sax.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    Carrier getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

}

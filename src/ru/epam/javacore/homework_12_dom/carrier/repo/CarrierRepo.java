package ru.epam.javacore.homework_12_dom.carrier.repo;

import ru.epam.javacore.homework_12_dom.carrier.domain.Carrier;
import ru.epam.javacore.homework_12_dom.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    Carrier getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

}

package main.ru.epam.javacore.homework_12_dom.carrier.repo;

import main.ru.epam.javacore.homework_12_dom.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_12_dom.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    Carrier getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

}

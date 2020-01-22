package main.ru.epam.javacore.homework_15_threads.carrier.repo;

import main.ru.epam.javacore.homework_15_threads.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_15_threads.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    Carrier getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

}

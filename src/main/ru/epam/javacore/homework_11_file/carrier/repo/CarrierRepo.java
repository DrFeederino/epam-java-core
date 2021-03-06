package main.ru.epam.javacore.homework_11_file.carrier.repo;

import main.ru.epam.javacore.homework_11_file.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_11_file.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    Carrier getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

}

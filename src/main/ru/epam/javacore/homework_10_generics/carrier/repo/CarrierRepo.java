package main.ru.epam.javacore.homework_10_generics.carrier.repo;

import main.ru.epam.javacore.homework_10_generics.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_10_generics.common.business.repo.CommonRepo;

import java.util.List;

public interface CarrierRepo extends CommonRepo<Carrier> {

    void add(Carrier carrier);

    Carrier getById(long id);

    Carrier getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

    List<Carrier> getAll();

    void update(Carrier carrier);
}

package main.ru.epam.javacore.homework_7_arrays_and_lists.carrier.repo;

import main.ru.epam.javacore.homework_7_arrays_and_lists.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_7_arrays_and_lists.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo {
    Carrier[] getAll();

    void add(Carrier carrier);

    Carrier getById(long id);

    Carrier[] getByName(String name);
}

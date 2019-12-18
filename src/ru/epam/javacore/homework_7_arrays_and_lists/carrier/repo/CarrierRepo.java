package ru.epam.javacore.homework_7_arrays_and_lists.carrier.repo;

import ru.epam.javacore.homework_7_arrays_and_lists.carrier.domain.Carrier;
import ru.epam.javacore.homework_7_arrays_and_lists.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo {
    Carrier[] getAll();

    void add(Carrier carrier);

    Carrier getById(long id);

    Carrier[] getByName(String name);
}

package ru.epam.javacore.homework_7_arrays_and_lists.transportation.repo;

import ru.epam.javacore.homework_7_arrays_and_lists.common.business.repo.CommonRepo;
import ru.epam.javacore.homework_7_arrays_and_lists.transportation.domain.Transportation;

public interface TransportationRepo extends CommonRepo {
    Transportation[] getAll();

    void add(Transportation transportation);

    Transportation getById(long id);
}

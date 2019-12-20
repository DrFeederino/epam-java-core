package ru.epam.javacore.homework_8_sorting.transportation.repo;

import ru.epam.javacore.homework_8_sorting.common.business.repo.CommonRepo;
import ru.epam.javacore.homework_8_sorting.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo {
    void add(Transportation transportation);

    void updateTransportation(Transportation transportation);

    Transportation getById(long id);

    List<Transportation> getAll();
}

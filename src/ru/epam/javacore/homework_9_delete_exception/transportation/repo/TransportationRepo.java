package ru.epam.javacore.homework_9_delete_exception.transportation.repo;

import ru.epam.javacore.homework_9_delete_exception.common.business.repo.CommonRepo;
import ru.epam.javacore.homework_9_delete_exception.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo {
    void add(Transportation transportation);

    void updateTransportation(Transportation transportation);

    Transportation getById(long id);

    List<Transportation> getAll();
}

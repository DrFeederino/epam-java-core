package main.ru.epam.javacore.homework_9_delete_exception.transportation.repo;

import main.ru.epam.javacore.homework_9_delete_exception.common.business.repo.CommonRepo;
import main.ru.epam.javacore.homework_9_delete_exception.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo {
    void add(Transportation transportation);

    void updateTransportation(Transportation transportation);

    Transportation getById(long id);

    List<Transportation> getAll();
}

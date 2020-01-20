package main.ru.epam.javacore.homework_10_generics.transportation.repo;

import main.ru.epam.javacore.homework_10_generics.common.business.repo.CommonRepo;
import main.ru.epam.javacore.homework_10_generics.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo<Transportation> {
    void add(Transportation transportation);

    Transportation getById(long id);

    List<Transportation> getAll();

    void update(Transportation transportation);
}

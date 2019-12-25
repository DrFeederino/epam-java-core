package ru.epam.javacore.homework_10_generics.transportation.repo;

import ru.epam.javacore.homework_10_generics.common.business.repo.CommonRepo;
import ru.epam.javacore.homework_10_generics.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo<Transportation> {
    void add(Transportation transportation);

    Transportation getById(long id);

    List<Transportation> getAll();

    void update(Transportation transportation);
}

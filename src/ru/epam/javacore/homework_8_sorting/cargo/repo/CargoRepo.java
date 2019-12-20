package ru.epam.javacore.homework_8_sorting.cargo.repo;

import ru.epam.javacore.homework_8_sorting.cargo.domain.Cargo;
import ru.epam.javacore.homework_8_sorting.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo {

    void add(Cargo cargo);

    void updateCargo(Cargo cargo);

    Cargo getById(long id);

    Cargo[] getByName(String name);

    List<Cargo> getAll();
}

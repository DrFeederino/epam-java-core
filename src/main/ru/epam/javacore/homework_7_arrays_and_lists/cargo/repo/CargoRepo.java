package main.ru.epam.javacore.homework_7_arrays_and_lists.cargo.repo;

import main.ru.epam.javacore.homework_7_arrays_and_lists.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_7_arrays_and_lists.common.business.repo.CommonRepo;

public interface CargoRepo extends CommonRepo {
    Cargo[] getAll();

    void add(Cargo cargo);

    Cargo getById(long id);

    Cargo[] getByName(String name);
}

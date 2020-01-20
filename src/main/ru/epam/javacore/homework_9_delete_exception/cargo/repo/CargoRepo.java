package main.ru.epam.javacore.homework_9_delete_exception.cargo.repo;

import main.ru.epam.javacore.homework_9_delete_exception.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_9_delete_exception.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo {

    void add(Cargo cargo);

    void updateCargo(Cargo cargo);

    Cargo getById(long id);

    Cargo[] getByName(String name);

    List<Cargo> getAll();
}

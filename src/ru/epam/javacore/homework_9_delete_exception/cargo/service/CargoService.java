package ru.epam.javacore.homework_9_delete_exception.cargo.service;

import ru.epam.javacore.homework_9_delete_exception.cargo.domain.Cargo;
import ru.epam.javacore.homework_9_delete_exception.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService {
    void add(Cargo cargo);

    void updateCargo(Cargo cargo);

    Cargo getById(Long id);

    List<Cargo> getAll();

    List<Cargo> getByName(String name);

    void sortCargosByName();

    void sortCargosByWeight();

    void sortCargosByWeightAndName();
}

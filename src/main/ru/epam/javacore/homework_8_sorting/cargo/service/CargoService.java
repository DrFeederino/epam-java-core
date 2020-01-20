package main.ru.epam.javacore.homework_8_sorting.cargo.service;

import main.ru.epam.javacore.homework_8_sorting.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_8_sorting.common.business.service.CommonService;

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

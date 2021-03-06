package main.ru.epam.javacore.homework_7_arrays_and_lists.cargo.service;

import main.ru.epam.javacore.homework_7_arrays_and_lists.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_7_arrays_and_lists.common.business.service.CommonService;

public interface CargoService extends CommonService {
    Cargo[] getAll();

    void add(Cargo cargo);

    Cargo getById(Long id);

    Cargo[] getByName(String name);
}

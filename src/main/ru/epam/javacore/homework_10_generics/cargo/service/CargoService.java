package main.ru.epam.javacore.homework_10_generics.cargo.service;

import main.ru.epam.javacore.homework_10_generics.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_10_generics.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_10_generics.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService<Cargo> {
    void add(Cargo cargo);

    Cargo getById(Long id);

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> getAll();

    List<Cargo> findByName(String name);

    void update(Cargo cargo);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}

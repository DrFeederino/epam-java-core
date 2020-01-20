package main.ru.epam.javacore.homework_10_generics.cargo.repo;

import main.ru.epam.javacore.homework_10_generics.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_10_generics.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_10_generics.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo> {

    void add(Cargo cargo);

    Cargo getById(long id);

    Cargo getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> getAll();

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

    void update(Cargo cargo);
}

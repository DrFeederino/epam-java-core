package ru.epam.javacore.homework_11_file.cargo.repo;

import ru.epam.javacore.homework_11_file.cargo.domain.Cargo;
import ru.epam.javacore.homework_11_file.cargo.search.CargoSearchCondition;
import ru.epam.javacore.homework_11_file.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

    Cargo getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}

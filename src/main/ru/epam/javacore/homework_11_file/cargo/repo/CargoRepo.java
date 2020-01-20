package main.ru.epam.javacore.homework_11_file.cargo.repo;

import main.ru.epam.javacore.homework_11_file.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_11_file.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_11_file.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

    Cargo getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}

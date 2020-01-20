package main.ru.epam.javacore.homework_13_sax.cargo.repo;

import main.ru.epam.javacore.homework_13_sax.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_13_sax.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_13_sax.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

    Cargo getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}

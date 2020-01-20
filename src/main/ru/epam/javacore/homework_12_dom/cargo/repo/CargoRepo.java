package main.ru.epam.javacore.homework_12_dom.cargo.repo;

import main.ru.epam.javacore.homework_12_dom.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_12_dom.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_12_dom.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

    Cargo getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}

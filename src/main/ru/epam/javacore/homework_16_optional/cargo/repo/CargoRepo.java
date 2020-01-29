package main.ru.epam.javacore.homework_16_optional.cargo.repo;

import main.ru.epam.javacore.homework_16_optional.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_16_optional.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_16_optional.common.business.repo.CommonRepo;

import java.util.List;
import java.util.Optional;

public interface CargoRepo extends CommonRepo<Cargo, Long> {
    Optional<Cargo> getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}

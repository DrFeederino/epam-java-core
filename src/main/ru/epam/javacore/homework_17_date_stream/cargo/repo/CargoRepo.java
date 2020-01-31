package main.ru.epam.javacore.homework_17_date_stream.cargo.repo;

import main.ru.epam.javacore.homework_17_date_stream.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_17_date_stream.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_17_date_stream.common.business.repo.CommonRepo;

import java.util.List;
import java.util.Optional;

public interface CargoRepo extends CommonRepo<Cargo, Long> {
    Optional<Cargo> getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}

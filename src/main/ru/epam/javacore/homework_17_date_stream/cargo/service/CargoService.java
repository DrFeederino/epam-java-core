package main.ru.epam.javacore.homework_17_date_stream.cargo.service;

import main.ru.epam.javacore.homework_17_date_stream.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_17_date_stream.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_17_date_stream.common.business.service.CommonService;

import java.util.List;
import java.util.Optional;

public interface CargoService extends CommonService<Cargo, Long> {
    Optional<Cargo> getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}

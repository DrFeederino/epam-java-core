package main.ru.epam.javacore.homework_16_optional.cargo.service;

import main.ru.epam.javacore.homework_16_optional.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_16_optional.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_16_optional.common.business.service.CommonService;

import java.util.List;
import java.util.Optional;

public interface CargoService extends CommonService<Cargo, Long> {
    Optional<Cargo> getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}

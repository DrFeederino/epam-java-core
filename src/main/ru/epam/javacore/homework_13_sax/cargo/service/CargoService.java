package main.ru.epam.javacore.homework_13_sax.cargo.service;

import main.ru.epam.javacore.homework_13_sax.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_13_sax.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_13_sax.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService<Cargo, Long> {

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}

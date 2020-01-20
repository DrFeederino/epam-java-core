package main.ru.epam.javacore.homework_12_dom.cargo.service;

import main.ru.epam.javacore.homework_12_dom.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_12_dom.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_12_dom.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService<Cargo, Long> {

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}

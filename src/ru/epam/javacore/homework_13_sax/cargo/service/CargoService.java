package ru.epam.javacore.homework_13_sax.cargo.service;

import ru.epam.javacore.homework_13_sax.cargo.domain.Cargo;
import ru.epam.javacore.homework_13_sax.cargo.search.CargoSearchCondition;
import ru.epam.javacore.homework_13_sax.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService<Cargo, Long> {

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);

}

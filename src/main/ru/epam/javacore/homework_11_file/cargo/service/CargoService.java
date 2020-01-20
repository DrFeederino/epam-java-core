package main.ru.epam.javacore.homework_11_file.cargo.service;

import main.ru.epam.javacore.homework_11_file.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_11_file.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_11_file.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService<Cargo, Long> {

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}

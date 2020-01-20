package main.ru.epam.javacore.homework_7_arrays_and_lists.transportation.service;

import main.ru.epam.javacore.homework_7_arrays_and_lists.common.business.service.CommonService;
import main.ru.epam.javacore.homework_7_arrays_and_lists.transportation.domain.Transportation;

public interface TransportationService extends CommonService {
    Transportation[] getAll();

    void add(Transportation transportation);

    Transportation getById(Long id);
}

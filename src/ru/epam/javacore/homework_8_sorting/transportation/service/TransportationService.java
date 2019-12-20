package ru.epam.javacore.homework_8_sorting.transportation.service;

import ru.epam.javacore.homework_8_sorting.common.business.service.CommonService;
import ru.epam.javacore.homework_8_sorting.transportation.domain.Transportation;

import java.util.List;

public interface TransportationService extends CommonService {
    void add(Transportation transportation);

    void updateTransportation(Transportation transportation);

    Transportation getById(Long id);

    List<Transportation> getAll();

}

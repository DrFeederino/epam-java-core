package main.ru.epam.javacore.homework_9_delete_exception.transportation.service;

import main.ru.epam.javacore.homework_9_delete_exception.common.business.service.CommonService;
import main.ru.epam.javacore.homework_9_delete_exception.transportation.domain.Transportation;

import java.util.List;

public interface TransportationService extends CommonService {
    void add(Transportation transportation);

    void updateTransportation(Transportation transportation);

    Transportation getById(Long id);

    List<Transportation> getAll();

}

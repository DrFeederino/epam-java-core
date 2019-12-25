package ru.epam.javacore.homework_10_generics.transportation.service;

import ru.epam.javacore.homework_10_generics.common.business.service.CommonService;
import ru.epam.javacore.homework_10_generics.transportation.domain.Transportation;

import java.util.List;

public interface TransportationService extends CommonService<Transportation> {
  void add(Transportation transportation);

  Transportation getById(Long id);

  List<Transportation> getAll();

  void update(Transportation transportation);

}

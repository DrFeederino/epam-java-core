package ru.epam.javacore.homework_10_generics.common.business.service;

import java.util.List;

public interface CommonService<T> {
    void add(T elem);

    T getById(Long id);

    List<T> getAll();

    void update(T elem);

    boolean deleteById(Long id);

    void printAll();
}

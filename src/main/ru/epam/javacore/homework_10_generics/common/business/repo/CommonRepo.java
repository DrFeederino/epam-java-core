package main.ru.epam.javacore.homework_10_generics.common.business.repo;

import java.util.List;

public interface CommonRepo<T> {
    void add(T elem);

    T getById(long id);

    List<T> getAll();

    boolean deleteById(long id);

    void update(T elem);
}

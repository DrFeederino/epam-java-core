package main.ru.epam.javacore.homework_11_file.common.business.repo;

import java.util.List;

public interface CommonRepo<TYPE, ID> {

    TYPE findById(ID id);

    void save(TYPE entity);

    boolean update(TYPE entity);

    boolean deleteById(ID id);

    List<TYPE> getAll();

    int countAll();
}

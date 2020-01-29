package main.ru.epam.javacore.homework_16_optional.storage.initor;

import main.ru.epam.javacore.homework_16_optional.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
    void initStorage() throws InitStorageException;
}

package main.ru.epam.javacore.homework_13_sax.storage.initor;

import main.ru.epam.javacore.homework_13_sax.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
    void initStorage() throws InitStorageException;
}

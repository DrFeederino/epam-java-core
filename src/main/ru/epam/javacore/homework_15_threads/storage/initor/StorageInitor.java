package main.ru.epam.javacore.homework_15_threads.storage.initor;

import main.ru.epam.javacore.homework_15_threads.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
    void initStorage() throws InitStorageException;
}

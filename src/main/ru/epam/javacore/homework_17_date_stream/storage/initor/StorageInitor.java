package main.ru.epam.javacore.homework_17_date_stream.storage.initor;

import main.ru.epam.javacore.homework_17_date_stream.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
    void initStorage() throws InitStorageException;
}

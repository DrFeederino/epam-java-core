package main.ru.epam.javacore.homework_12_dom.storage.initor;

import main.ru.epam.javacore.homework_12_dom.common.business.exception.checked.InitStorageException;

public interface StorageInitor {
    void initStorage() throws InitStorageException;
}

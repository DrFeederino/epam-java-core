package ru.epam.javacore.homework_11_file.storage.initor;

public final class StorageInitorWrapper {

    private StorageInitorWrapper() {

    }

    public static StorageInitor initStorageType(StorageInitorType storageInitorType) {
        switch (storageInitorType) {
            case FILE:
                return new FromFileStorageInitor();
            default:
                return new InMemoryStorageInitor();
        }
    }

    public static StorageInitor initStorageType(StorageInitorType storageInitorType, String pathname) {
        switch (storageInitorType) {
            case FILE:
                return new FromFileStorageInitor(pathname);
            default:
                return new InMemoryStorageInitor();
        }
    }
}

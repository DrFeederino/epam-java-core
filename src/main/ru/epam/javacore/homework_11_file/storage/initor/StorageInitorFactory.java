package main.ru.epam.javacore.homework_11_file.storage.initor;

public final class StorageInitorFactory {

    private StorageInitorFactory() {

    }

    public static StorageInitor getStorageInitor(StorageInitorType storageInitorType) {
        switch (storageInitorType) {
            case FILE:
                return new TextFileStorageInitor();
            case MEMORY:
                return new InMemoryStorageInitor();
            default:
                throw new RuntimeException("Unknown storage init type " + storageInitorType);
        }
    }

    public static StorageInitor initStorageType(StorageInitorType storageInitorType, String pathname) {
        switch (storageInitorType) {
            case FILE:
                return new TextFileStorageInitor(pathname);
            default:
                return new InMemoryStorageInitor();
        }
    }
}

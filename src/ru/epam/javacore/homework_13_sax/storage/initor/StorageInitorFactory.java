package ru.epam.javacore.homework_13_sax.storage.initor;

import ru.epam.javacore.homework_13_sax.storage.initor.fileinitor.SaxFileDataInit;
import ru.epam.javacore.homework_13_sax.storage.initor.fileinitor.TextFileDataInitor;
import ru.epam.javacore.homework_13_sax.storage.initor.fileinitor.XmlDomFileDataInitor;

public final class StorageInitorFactory {

    private StorageInitorFactory() {

    }

    public static StorageInitor getStorageInitor(InitStorageType initStorageType) {
        switch (initStorageType) {

            case MEMORY: {
                return new InMemoryStorageInitor();
            }
            case TEXT_FILE: {
                return new TextFileDataInitor();
            }
            case XML_DOM_FILE: {
                return new XmlDomFileDataInitor();
            }
            case SAX_FILE: {
                return new SaxFileDataInit();
            }
            default: {
                throw new RuntimeException("Unknown storage init type " + initStorageType);
            }
        }
    }

}

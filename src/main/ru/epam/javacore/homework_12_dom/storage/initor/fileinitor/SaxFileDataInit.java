package main.ru.epam.javacore.homework_12_dom.storage.initor.fileinitor;

import main.ru.epam.javacore.homework_12_dom.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_12_dom.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_12_dom.common.business.exception.checked.InitStorageException;
import main.ru.epam.javacore.homework_12_dom.common.solutions.utils.FileUtils;
import main.ru.epam.javacore.homework_12_dom.transportation.domain.Transportation;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;
import java.util.Map;

public class SaxFileDataInit extends BaseFileInitor {
    private static final String FILE = "/ru/epam/javacore/homework_12_dom/xmldata.xml";


    @Override
    public void initStorage() throws InitStorageException {
        File file = null;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            StorageHandler storageHandler = new StorageHandler();
            file = FileUtils.createFileFromResource("storage", "txt", FILE);
            saxParser.parse(file, storageHandler);
            Map<String, Cargo> cargoMap = storageHandler.getCargos();
            Map<String, Carrier> carrierMap = storageHandler.getCarriers();
            List<ParsedTransportation> transportations = storageHandler.getTransportations();

            setReferencesBetweenEntities(cargoMap, carrierMap, transportations);
            persistCargos(cargoMap.values());
            persistCarriers(carrierMap.values());
            List<Transportation> transportationList = getTransportationsFromParsedObject(transportations);
            persistTransportations(transportationList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                file.delete();
            }
        }

    }
}

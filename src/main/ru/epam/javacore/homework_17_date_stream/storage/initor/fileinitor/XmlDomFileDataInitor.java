package main.ru.epam.javacore.homework_17_date_stream.storage.initor.fileinitor;

import main.ru.epam.javacore.homework_17_date_stream.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_17_date_stream.cargo.domain.CargoType;
import main.ru.epam.javacore.homework_17_date_stream.cargo.domain.ClothesCargo;
import main.ru.epam.javacore.homework_17_date_stream.cargo.domain.FoodCargo;
import main.ru.epam.javacore.homework_17_date_stream.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_17_date_stream.carrier.domain.CarrierType;
import main.ru.epam.javacore.homework_17_date_stream.common.business.exception.checked.InitStorageException;
import main.ru.epam.javacore.homework_17_date_stream.common.solutions.utils.FileUtils;
import main.ru.epam.javacore.homework_17_date_stream.common.solutions.utils.JavaTimeUtils;
import main.ru.epam.javacore.homework_17_date_stream.common.solutions.utils.xml.dom.XmlDomUtils;
import main.ru.epam.javacore.homework_17_date_stream.transportation.domain.Transportation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static main.ru.epam.javacore.homework_17_date_stream.common.solutions.utils.xml.dom.XmlDomUtils.getOnlyElement;
import static main.ru.epam.javacore.homework_17_date_stream.common.solutions.utils.xml.dom.XmlDomUtils.getOnlyElementTextContent;

public class XmlDomFileDataInitor extends BaseFileInitor {

    private static final String FILE = "/ru/epam/javacore/homework_13_sax/xmldata.xml";
    private static Map<String, Cargo> cargoMap = null;
    private static Map<String, Carrier> carrierMap = null;
    private static List<ParsedTransportation> transportations = null;

    @Override
    public void initStorage() throws InitStorageException {
        File file = null;
        try {
            file = getFileWithInitData();
            Document document = XmlDomUtils.getDocument(file);

            Runnable cargoInit = () -> {
                try {
                    parseCargos(document);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

            Runnable carrierInit = () -> parseCarriers(document);

            Runnable transportationInit = () -> {
                try {
                    parseTransportationsData(document);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

            List<Thread> threads = new ArrayList<>();

            threads.add(new Thread(cargoInit));
            threads.add(new Thread(carrierInit));
            threads.add(new Thread(transportationInit));

            for (Thread thread : threads) {
                thread.start();
                thread.join();
            }

            setReferencesBetweenEntities(cargoMap, carrierMap, transportations);

            persistCargos(cargoMap.values());
            persistCarriers(carrierMap.values());
            List<Transportation> transportationList = getTransportationsFromParsedObject(transportations);
            persistTransportations(transportationList);

        } catch (Exception e) {
            e.printStackTrace();
            throw new InitStorageException(e.getMessage());
        } finally {
            if (file != null) {
                file.delete();
            }
        }
    }

    private File getFileWithInitData() throws IOException {
        return FileUtils.createFileFromResource("storage", "txt", FILE);
    }

    private void parseCargos(Document document) {
        cargoMap = new LinkedHashMap<>();

        Element root = getOnlyElement(document, "cargos");
        NodeList xmlCargos = root.getElementsByTagName("cargo");

        if (xmlCargos != null) {
            for (int i = 0; i < xmlCargos.getLength(); i++) {
                Map.Entry<String, Cargo> parsedData = parseCargo(xmlCargos.item(i));
                cargoMap.put(parsedData.getKey(), parsedData.getValue());
            }
        }
    }

    private Map.Entry<String, Cargo> parseCargo(Node cargoXml) {
        Element cargoElem = ((Element) cargoXml);

        String id = cargoElem.getAttribute("id");
        CargoType cargoType = CargoType.valueOf(cargoElem.getAttribute("type"));

        Cargo cargo;
        if (CargoType.FOOD.equals(cargoType)) {
            FoodCargo foodCargo = new FoodCargo();
            LocalDate expirationDate = JavaTimeUtils
                    .valueOf(getOnlyElementTextContent(cargoElem, "expirationDate"));
            foodCargo.setExpirationDate(expirationDate);
            foodCargo.setStoreTemperature(
                    Integer.parseInt(getOnlyElementTextContent(cargoElem, "storeTemperature")));
            cargo = foodCargo;
        } else {
            ClothesCargo clothesCargo = new ClothesCargo();
            clothesCargo.setMaterial(getOnlyElementTextContent(cargoElem, "material"));
            clothesCargo.setSize(getOnlyElementTextContent(cargoElem, "size"));
            cargo = clothesCargo;
        }

        cargo.setName(getOnlyElementTextContent(cargoElem, "name"));
        cargo.setWeight(Integer.parseInt(getOnlyElementTextContent(cargoElem, "weight")));

        return new SimpleEntry<>(id, cargo);
    }

    private void parseCarriers(Document document) {
        carrierMap = new LinkedHashMap<>();

        Element root = getOnlyElement(document, "carriers");
        NodeList xmlCarriers = root.getElementsByTagName("carrier");

        if (xmlCarriers != null) {
            for (int i = 0; i < xmlCarriers.getLength(); i++) {
                Map.Entry<String, Carrier> parsedData = parseCarrier(xmlCarriers.item(i));
                carrierMap.put(parsedData.getKey(), parsedData.getValue());
            }
        }
    }

    private Map.Entry<String, Carrier> parseCarrier(Node cargoXml) {
        Element carrierElement = ((Element) cargoXml);

        String id = carrierElement.getAttribute("id");
        Carrier carrier = new Carrier();

        carrier.setName(getOnlyElementTextContent(carrierElement, "name"));
        carrier.setAddress(getOnlyElementTextContent(carrierElement, "address"));
        String carrierTypeStr = getOnlyElementTextContent(carrierElement, "type");
        carrier.setCarrierType(CarrierType.valueOf(carrierTypeStr));

        return new SimpleEntry<>(id, carrier);
    }

    private void parseTransportationsData(Document document) {
        transportations = new ArrayList<>();

        Element root = getOnlyElement(document, "transportations");
        NodeList xmlTransportations = root.getElementsByTagName("transportation");

        if (xmlTransportations != null) {
            for (int i = 0; i < xmlTransportations.getLength(); i++) {
                ParsedTransportation parsedData = parseTransportationData(xmlTransportations.item(i));
                transportations.add(parsedData);
            }
        }
    }

    private ParsedTransportation parseTransportationData(Node transportationXml) {
        Element transportationElement = ((Element) transportationXml);

        ParsedTransportation result = new ParsedTransportation();
        String cargoRef = transportationElement.getAttribute("cargoref");
        result.setCargoRef(cargoRef);
        String carrierRef = transportationElement.getAttribute("carrierref");
        result.setCarrierRef(carrierRef);

        Transportation transportation = new Transportation();
        transportation.setBillTo(getOnlyElementTextContent(transportationElement, "billto"));
        transportation.setDescription(getOnlyElementTextContent(transportationElement, "description"));
        String beginDataStr = getOnlyElementTextContent(transportationElement, "transportationBeginDate");
        transportation.setTransportationBeginDate(JavaTimeUtils.valueOf(beginDataStr));
        result.setTransportation(transportation);

        return result;
    }

}

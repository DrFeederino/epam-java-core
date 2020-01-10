package ru.epam.javacore.homework_13_sax.storage.initor.fileinitor;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.epam.javacore.homework_13_sax.cargo.domain.Cargo;
import ru.epam.javacore.homework_13_sax.cargo.domain.ClothersCargo;
import ru.epam.javacore.homework_13_sax.cargo.domain.FoodCargo;
import ru.epam.javacore.homework_13_sax.carrier.domain.Carrier;
import ru.epam.javacore.homework_13_sax.carrier.domain.CarrierType;
import ru.epam.javacore.homework_13_sax.common.solutions.utils.JavaUtilDateUtils;
import ru.epam.javacore.homework_13_sax.transportation.domain.Transportation;

import java.util.*;

public class StorageHandler extends DefaultHandler {
    private Map<String, Cargo> cargos;
    private FoodCargo foodCargo;
    private ClothersCargo clothersCargo;
    private Map<String, Carrier> carriers;
    private Carrier carrier;
    private List<BaseFileInitor.ParsedTransportation> transportations;
    private Transportation transportation;
    private BaseFileInitor.ParsedTransportation parsedTransportation;
    private String id;
    private String cargoRef;
    private String carrierRef;
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.setLength(0);
        switch (qName) {
            case "cargos": {
                cargos = new LinkedHashMap<>();
                break;
            }
            case "carriers": {
                carriers = new LinkedHashMap<>();
                break;
            }
            case "transportations": {
                transportations = new ArrayList<>();
                break;
            }
            case "cargo": {
                setCargo(attributes);
                break;
            }
            case "carrier": {
                setCarrier(attributes);
                break;
            }
            case "transportation": {
                setTransportation(attributes);
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String data = stringBuilder.toString();
        switch (qName) {
            case "cargo": {
                putCargoInMap();
                break;
            }
            case "carrier": {
                putCarrierInMap();
                break;
            }
            case "transportation": {
                putTransportationInList();
                break;
            }
            case "name": {
                if (carrier != null) {
                    carrier.setName(data);
                } else {
                    if (clothersCargo == null) {
                        foodCargo.setName(data);
                    } else {
                        clothersCargo.setName(data);
                    }
                }
                break;
            }
            case "weight": {
                if (clothersCargo == null) {
                    foodCargo.setWeight(Integer.valueOf(data));
                } else {
                    clothersCargo.setWeight(Integer.valueOf(data));
                }
                break;
            }
            case "size": {
                clothersCargo.setSize(data);
                break;
            }
            case "material": {
                clothersCargo.setMaterial(data);
                break;
            }
            case "expirationDate": {
                try {
                    Date date = JavaUtilDateUtils.valueOf(data);
                    foodCargo.setExpirationDate(date);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "storeTemperature": {
                foodCargo.setStoreTemperature(Integer.valueOf(data));
                break;
            }
            case "type": {
                if ("ship".equalsIgnoreCase(data)) {
                    carrier.setCarrierType(CarrierType.SHIP);
                }
                if ("plane".equalsIgnoreCase(data)) {
                    carrier.setCarrierType(CarrierType.PLANE);
                }
                if ("car".equalsIgnoreCase(data)) {
                    carrier.setCarrierType(CarrierType.CAR);
                }
                break;
            }
            case "address": {
                carrier.setAddress(data);
                break;
            }
            case "billTo": {
                transportation.setBillTo(data);
                break;
            }
            case "transportationBeginDate": {
                try {
                    transportation.setTransportationBeginDate(JavaUtilDateUtils.valueOf(data));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "description": {
                transportation.setDescription(data);
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        stringBuilder.append(data);
    }

    public void setCargo(Attributes attributes) {
        id = attributes.getValue("id");
        String type = attributes.getValue("type");
        if ("food".equalsIgnoreCase(type)) {
            foodCargo = new FoodCargo();
        } else if ("clothers".equalsIgnoreCase(type)) {
            clothersCargo = new ClothersCargo();
        }
    }

    public void setCarrier(Attributes attributes) {
        carrier = new Carrier();
        id = attributes.getValue("id");
    }

    public void setTransportation(Attributes attributes) {
        parsedTransportation = new BaseFileInitor.ParsedTransportation();
        transportation = new Transportation();
        cargoRef = attributes.getValue("cargoref");
        carrierRef = attributes.getValue("carrierref");
        parsedTransportation.setCargoRef(cargoRef);
        parsedTransportation.setCarrierRef(carrierRef);
    }

    public void putCargoInMap() {
        cargos.put(id, foodCargo == null ? clothersCargo : foodCargo);
        id = null;
        foodCargo = null;
        clothersCargo = null;
    }

    public void putCarrierInMap() {
        carriers.put(id, carrier);
        id = null;
        carrier = null;
    }

    public void putTransportationInList() {
        parsedTransportation.setTransportation(transportation);
        transportations.add(parsedTransportation);
        id = null;
        transportation = null;
        parsedTransportation = null;
        carrierRef = null;
        cargoRef = null;
    }

    public Map<String, Cargo> getCargos() {
        return cargos;
    }

    public Map<String, Carrier> getCarriers() {
        return carriers;
    }

    public List<BaseFileInitor.ParsedTransportation> getTransportations() {
        return transportations;
    }
}

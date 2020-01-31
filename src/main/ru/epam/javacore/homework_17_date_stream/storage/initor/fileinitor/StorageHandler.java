package main.ru.epam.javacore.homework_17_date_stream.storage.initor.fileinitor;

import main.ru.epam.javacore.homework_17_date_stream.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_17_date_stream.cargo.domain.ClothesCargo;
import main.ru.epam.javacore.homework_17_date_stream.cargo.domain.FoodCargo;
import main.ru.epam.javacore.homework_17_date_stream.carrier.domain.Carrier;
import main.ru.epam.javacore.homework_17_date_stream.carrier.domain.CarrierType;
import main.ru.epam.javacore.homework_17_date_stream.common.solutions.utils.JavaTimeUtils;
import main.ru.epam.javacore.homework_17_date_stream.transportation.domain.Transportation;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StorageHandler extends DefaultHandler {
    private Map<String, Cargo> cargos;
    private FoodCargo foodCargo;
    private ClothesCargo clothesCargo;
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
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
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
    public void endElement(String uri, String localName, String qName) {
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
                    if (clothesCargo == null) {
                        foodCargo.setName(data);
                    } else {
                        clothesCargo.setName(data);
                    }
                }
                break;
            }
            case "weight": {
                if (clothesCargo == null) {
                    foodCargo.setWeight(Integer.parseInt(data));
                } else {
                    clothesCargo.setWeight(Integer.parseInt(data));
                }
                break;
            }
            case "size": {
                clothesCargo.setSize(data);
                break;
            }
            case "material": {
                clothesCargo.setMaterial(data);
                break;
            }
            case "expirationDate": {
                try {
                    LocalDate date = JavaTimeUtils.valueOf(data);
                    foodCargo.setExpirationDate(date);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case "storeTemperature": {
                foodCargo.setStoreTemperature(Integer.parseInt(data));
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
                    transportation.setTransportationBeginDate(JavaTimeUtils.valueOf(data));
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
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);
        stringBuilder.append(data);
    }

    public void setCargo(Attributes attributes) {
        id = attributes.getValue("id");
        String type = attributes.getValue("type");
        if ("food".equalsIgnoreCase(type)) {
            foodCargo = new FoodCargo();
        } else if ("clothers".equalsIgnoreCase(type)) {
            clothesCargo = new ClothesCargo();
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
        cargos.put(id, foodCargo == null ? clothesCargo : foodCargo);
        id = null;
        foodCargo = null;
        clothesCargo = null;
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

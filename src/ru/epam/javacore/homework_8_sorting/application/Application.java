package ru.epam.javacore.homework_8_sorting.application;

import ru.epam.javacore.homework_8_sorting.application.serviceholder.ServiceHolder;
import ru.epam.javacore.homework_8_sorting.application.serviceholder.StorageType;
import ru.epam.javacore.homework_8_sorting.cargo.domain.Cargo;
import ru.epam.javacore.homework_8_sorting.cargo.service.CargoService;
import ru.epam.javacore.homework_8_sorting.carrier.domain.Carrier;
import ru.epam.javacore.homework_8_sorting.carrier.service.CarrierService;
import ru.epam.javacore.homework_8_sorting.common.solutions.utils.CollectionUtils;
import ru.epam.javacore.homework_8_sorting.storage.initor.InMemoryStorageInitor;
import ru.epam.javacore.homework_8_sorting.storage.initor.StorageInitor;
import ru.epam.javacore.homework_8_sorting.transportation.service.TransportationService;

public class Application {

    private static final String SEPARATOR = "--------------";
    private static CargoService cargoService;
    private static CarrierService carrierService;
    private static TransportationService transportationService;

    public static void main(String[] args) {
        ServiceHolder.initServiceHolder(StorageType.COLLECTION);
        cargoService = ServiceHolder.getInstance().getCargoService();
        carrierService = ServiceHolder.getInstance().getCarrierService();
        transportationService = ServiceHolder.getInstance().getTransportationService();

        StorageInitor storageInitor = new InMemoryStorageInitor();
        storageInitor.initStorage();

        printStorageData();
        doSearchOperations();
        updateOperations();
        sortCargosByNameAndPrint();
        sortCargosByWeightAndNameAndPrint();
        sortCargosByWeightAndPrint();
    }

    private static void printStorageData() {
        System.out.println("ALL CARGOS");
        cargoService.printAll();
        printSeparator();

        System.out.println("ALL CARRIERS");
        carrierService.printAll();
        printSeparator();

        System.out.println("ALL TRANSPOORTATIONS");
        transportationService.printAll();
        printSeparator();
    }

    private static void doSearchOperations() {
        System.out.println("SEARCH CARGO BY ID = 1");
        System.out.println(cargoService.getById(1L));
        printSeparator();

        System.out.println("SEARCH CARRIER BY ID = 8");
        System.out.println(carrierService.getById(8L));
        printSeparator();

        System.out.println("SEARCH CARGOES BY NAME = 'Clothers_Name_1'");
        CollectionUtils.printCollection(cargoService.getByName("Clothers_Name_1"));
        printSeparator();

        System.out.println("SEARCH CARRIERS BY NAME = 'Carrier_Name'");
        CollectionUtils.printCollection(carrierService.getByName("Carrier_Name"));
    }

    private static void updateOperations() {
        System.out.println("UPDATE CARGO WITH ID = 1");
        Cargo cargo = cargoService.getById(1L);
        cargo.setName("UPDATED CARGO NAME");
        cargoService.updateCargo(cargo);
        System.out.println(cargo);
        printSeparator();

        System.out.println("UPDATE CARRIER WITH ID = 8");
        Carrier carrier = carrierService.getById(8L);
        carrier.setName("UPDATED CARRIER NAME");
        carrierService.updateCarrier(carrier);
        System.out.println(carrier);
        printSeparator();
    }

    private static void sortCargosByNameAndPrint() {
        printSeparator();
        System.out.println("SORTING CARGOS BY NAME");
        cargoService.sortCargosByName();
        cargoService.printAll();
        printSeparator();
    }

    private static void sortCargosByWeightAndPrint() {
        printSeparator();
        System.out.println("SORTING CARGOS BY WEIGHT");
        cargoService.sortCargosByWeight();
        cargoService.printAll();
        printSeparator();
    }

    private static void sortCargosByWeightAndNameAndPrint() {
        printSeparator();
        System.out.println("SORTING CARGOS BY NAME AND WEIGHT");
        cargoService.sortCargosByWeightAndName();
        cargoService.printAll();
        printSeparator();
    }

    private static void printSeparator() {
        System.out.println(SEPARATOR);
    }

}

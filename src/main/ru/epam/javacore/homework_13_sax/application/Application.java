package main.ru.epam.javacore.homework_13_sax.application;

import main.ru.epam.javacore.homework_13_sax.application.serviceholder.ServiceHolder;
import main.ru.epam.javacore.homework_13_sax.application.serviceholder.StorageType;
import main.ru.epam.javacore.homework_13_sax.cargo.domain.Cargo;
import main.ru.epam.javacore.homework_13_sax.cargo.domain.CargoField;
import main.ru.epam.javacore.homework_13_sax.cargo.search.CargoSearchCondition;
import main.ru.epam.javacore.homework_13_sax.cargo.service.CargoService;
import main.ru.epam.javacore.homework_13_sax.carrier.service.CarrierService;
import main.ru.epam.javacore.homework_13_sax.common.business.exception.checked.InitStorageException;
import main.ru.epam.javacore.homework_13_sax.common.business.exception.checked.ReportException;
import main.ru.epam.javacore.homework_13_sax.common.solutions.search.OrderType;
import main.ru.epam.javacore.homework_13_sax.common.solutions.utils.CollectionUtils;
import main.ru.epam.javacore.homework_13_sax.reporting.ReportDefaultService;
import main.ru.epam.javacore.homework_13_sax.reporting.ReportService;
import main.ru.epam.javacore.homework_13_sax.storage.initor.InitStorageType;
import main.ru.epam.javacore.homework_13_sax.storage.initor.StorageInitor;
import main.ru.epam.javacore.homework_13_sax.transportation.service.TransportationService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import static java.util.Collections.singletonList;
import static main.ru.epam.javacore.homework_13_sax.cargo.domain.CargoField.NAME;
import static main.ru.epam.javacore.homework_13_sax.cargo.domain.CargoField.WEIGHT;
import static main.ru.epam.javacore.homework_13_sax.common.solutions.search.OrderType.ASC;
import static main.ru.epam.javacore.homework_13_sax.common.solutions.search.OrderType.DESC;
import static main.ru.epam.javacore.homework_13_sax.storage.initor.StorageInitorFactory.getStorageInitor;

public class Application {

    private static final String SEPARATOR = "--------------";
    private static CargoService cargoService;
    private static CarrierService carrierService;
    private static TransportationService transportationService;

    public static void main(String[] args) {
        try {
            ServiceHolder.initServiceHolder(StorageType.COLLECTION);
            cargoService = ServiceHolder.getInstance().getCargoService();
            carrierService = ServiceHolder.getInstance().getCarrierService();
            transportationService = ServiceHolder.getInstance().getTransportationService();

            StorageInitor storageInitor = getStorageInitor(InitStorageType.SAX_FILE);
            storageInitor.initStorage();

            printStorageData();
            demoSearchOperations();
            demoSortOperations();
            demoExceptions();

            demoReportService();
        } catch (InitStorageException e) {
            e.getCause().printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void demoSearchOperations() {
        System.out.println("SEARCH CARGO BY ID = 1");
        System.out.println(cargoService.findById(1L));
        printSeparator();

        System.out.println("SEARCH CARRIER BY ID = 8");
        System.out.println(carrierService.findById(8L));
        printSeparator();

        System.out.println("SEARCH CARGOES BY NAME = 'Clothers_Name_1'");
        CollectionUtils.printCollection(cargoService.findByName("Clothers_Name_1"));
        printSeparator();

        System.out.println("SEARCH CARRIERS BY NAME = 'Carrier_Name'");
        CollectionUtils.printCollection(carrierService.findByName("Carrier_Name"));
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

    private static void printSeparator() {
        System.out.println(SEPARATOR);
    }

    private static void demoSortOperations() {
        demoCargoSorting(singletonList(NAME), ASC);
        demoCargoSorting(singletonList(NAME), DESC);

        demoCargoSorting(singletonList(WEIGHT), ASC);
        demoCargoSorting(singletonList(WEIGHT), DESC);

        demoCargoSorting(Arrays.asList(NAME, WEIGHT), ASC);
        demoCargoSorting(Arrays.asList(NAME, WEIGHT), DESC);
    }

    private static String getOrderingConditionsAsString(CargoSearchCondition condition) {
        StringBuilder result = new StringBuilder();
        result.append(" ORDER BY ");

        Iterator<CargoField> iter = condition.getSortFields().iterator();
        while (iter.hasNext()) {
            CargoField fld = iter.next();
            result.append(fld);

            if (iter.hasNext()) {
                result.append(",");
            }
        }

        result.append(" ").append(condition.getOrderType());

        return result.toString();
    }

    private static void demoCargoSorting(Collection<CargoField> sortFields, OrderType orderType) {
        CargoSearchCondition cargoSearchCondition = new CargoSearchCondition();
        cargoSearchCondition.setOrderType(orderType);
        cargoSearchCondition.setSortFields(new LinkedHashSet<>(sortFields));
        System.out.println(
                "---------Sorting '" + getOrderingConditionsAsString(cargoSearchCondition) + "'------");
        cargoService.search(cargoSearchCondition);
        cargoService.printAll();
        System.out.println();
    }

    private static void demoExceptions() {
        System.out.println("------Demo  exceptions------------");
        Long firstCargo = cargoService.getAll().get(0).getId();
        Cargo cargo = cargoService.getByIdFetchingTransportations(firstCargo);
        System.out.println("Try to delete cargo");
        System.out.println("Cargo details:");
        System.out.println("id: " + cargo.getId());
        System.out.println("name: " + cargo.getName());
        System.out.println("total transportations: " + (cargo.getTransportations() != null ? cargo
                .getTransportations().size() : 0));
        System.out.println();
        try {
            cargoService.deleteById(cargo.getId());
        } catch (Exception e) {
            System.out.println("OOPS, something went wrong!");
            System.out.println(e.getMessage());
        }
    }

    private static void demoReportService() throws ReportException {
        System.out.println("----------Demo report service ---------------");
        ReportService reportService = new ReportDefaultService(
                cargoService, carrierService, transportationService
        );
        reportService.exportData();
    }
}

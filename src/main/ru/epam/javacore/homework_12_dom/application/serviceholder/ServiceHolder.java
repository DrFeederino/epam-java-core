package main.ru.epam.javacore.homework_12_dom.application.serviceholder;

import main.ru.epam.javacore.homework_12_dom.cargo.repo.impl.CargoArrayRepoImpl;
import main.ru.epam.javacore.homework_12_dom.cargo.repo.impl.CargoCollectionRepoImpl;
import main.ru.epam.javacore.homework_12_dom.cargo.service.CargoService;
import main.ru.epam.javacore.homework_12_dom.cargo.service.CargoServiceImpl;
import main.ru.epam.javacore.homework_12_dom.carrier.repo.impl.CarrierArrayRepoImpl;
import main.ru.epam.javacore.homework_12_dom.carrier.repo.impl.CarrierCollectionRepoImpl;
import main.ru.epam.javacore.homework_12_dom.carrier.service.CarrierService;
import main.ru.epam.javacore.homework_12_dom.carrier.service.CarrierServiceImpl;
import main.ru.epam.javacore.homework_12_dom.transportation.repo.impl.TransportationArrayRepoImpl;
import main.ru.epam.javacore.homework_12_dom.transportation.repo.impl.TransportationCollectionRepoImpl;
import main.ru.epam.javacore.homework_12_dom.transportation.service.TransportationService;
import main.ru.epam.javacore.homework_12_dom.transportation.service.TransportationServiceImpl;

public final class ServiceHolder {

    private static ServiceHolder instance = null;

    private final CarrierService carrierService;
    private final CargoService cargoService;
    private final TransportationService transportationService;

    private ServiceHolder(StorageType storageType) {
        SimpleServiceHolder initedServiceHolder = getInitedServiceHolder(storageType);
        cargoService = initedServiceHolder.cargoService;
        carrierService = initedServiceHolder.carrierService;
        transportationService = initedServiceHolder.transportationService;
    }

    public static void initServiceHolder(StorageType storageType) {
        ServiceHolder.instance = new ServiceHolder(storageType);
    }

    public static ServiceHolder getInstance() {
        return instance;
    }

    private SimpleServiceHolder getInitedServiceHolder(StorageType storageType) {
        switch (storageType) {

            case ARRAY: {
                return new SimpleServiceHolder(
                        new CarrierServiceImpl(new CarrierArrayRepoImpl()),
                        new CargoServiceImpl(new CargoArrayRepoImpl()),
                        new TransportationServiceImpl(new TransportationArrayRepoImpl()));
            }

            default: {
                return new SimpleServiceHolder(
                        new CarrierServiceImpl(new CarrierCollectionRepoImpl()),
                        new CargoServiceImpl(new CargoCollectionRepoImpl()),
                        new TransportationServiceImpl(new TransportationCollectionRepoImpl()));
            }
        }
    }

    public CarrierService getCarrierService() {
        return carrierService;
    }

    public CargoService getCargoService() {
        return cargoService;
    }

    public TransportationService getTransportationService() {
        return transportationService;
    }

    private static class SimpleServiceHolder {

        private final CarrierService carrierService;
        private final CargoService cargoService;
        private final TransportationService transportationService;

        public SimpleServiceHolder(
                CarrierService carrierService,
                CargoService cargoService,
                TransportationService transportationService) {
            this.carrierService = carrierService;
            this.cargoService = cargoService;
            this.transportationService = transportationService;
        }
    }
}

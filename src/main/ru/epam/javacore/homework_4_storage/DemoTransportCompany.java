package main.ru.epam.javacore.homework_4_storage;

import main.ru.epam.javacore.homework_4_storage.cargo.Cargo;
import main.ru.epam.javacore.homework_4_storage.carrier.Carrier;
import main.ru.epam.javacore.homework_4_storage.storage.Storage;
import main.ru.epam.javacore.homework_4_storage.transportation.Transportation;

public class DemoTransportCompany {

    public static void main(String[] args) {

        Cargo[] cargos = {
                new Cargo("Headphones"),
                new Cargo("Phone"),
                new Cargo("Clothes")
        };

        Carrier[] carriers = {
                new Carrier("Mediocre Carrier"),
                new Carrier("Very good carrier"),
                new Carrier("This one is the cheapest carrier")
        };

        Transportation[] transportations = {
                new Transportation("Evgeniy Pavlovich"),
                new Transportation("Yuliy Anatolievich"),
                new Transportation("Eremey Vadimovich"),
        };

        Storage storage = new Storage();

        for (Cargo cargo : cargos) {
            storage.addCargo(cargo);
        }

        for (Carrier carrier : carriers) {
            storage.addCarrier(carrier);
        }

        for (Transportation transportation : transportations) {
            storage.addTransportation(transportation);
        }

        storage.printCargos();
        storage.printCarriers();
        storage.printTransportations();
    }

}

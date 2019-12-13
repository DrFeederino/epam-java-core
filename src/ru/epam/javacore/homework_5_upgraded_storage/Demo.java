package ru.epam.javacore.homework_5_upgraded_storage;

import ru.epam.javacore.homework_5_upgraded_storage.domain.cargo.BoxCargo;
import ru.epam.javacore.homework_5_upgraded_storage.domain.cargo.Cargo;
import ru.epam.javacore.homework_5_upgraded_storage.domain.cargo.PackageCargo;
import ru.epam.javacore.homework_5_upgraded_storage.domain.carrier.Carrier;
import ru.epam.javacore.homework_5_upgraded_storage.domain.transportation.Transportation;
import ru.epam.javacore.homework_5_upgraded_storage.storage.Storage;

public class Demo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Cargo cargo = new Cargo("A" + i + 1);
            Storage.addCargo(cargo);
        }
        Storage.printCargos();
        Cargo[] cargos = Storage.getCargos();
        Cargo cargo = Storage.getCargoById(1L);

        for (int i = 0; i < 5; i++) {
            Transportation transportation = new Transportation("A" + i + 1);
            Storage.addTransportation(transportation);
        }
        Storage.printTransportations();
        Transportation[] transportations = Storage.getTransportations();
        Transportation transportation = Storage.getTransportationById(10L);

        for (int i = 0; i < 5; i++) {
            Carrier carrier = new Carrier("A" + i + 1);
            Storage.addCarrier(carrier);
        }
        Storage.printCarriers();
        Carrier[] carriers = Storage.getCarriers();
        Carrier carrier = Storage.getCarrierById(15L);

        BoxCargo box = new BoxCargo(new float[]{1f, 2f, 3f});
        box.calculateVolume();

        PackageCargo packageCargo = new PackageCargo(999f);
        packageCargo.calculateInsurance();
    }
}

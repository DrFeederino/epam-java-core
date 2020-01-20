package main.ru.epam.javacore.homework_5_upgraded_storage.storage;

import main.ru.epam.javacore.homework_5_upgraded_storage.domain.cargo.Cargo;
import main.ru.epam.javacore.homework_5_upgraded_storage.domain.carrier.Carrier;
import main.ru.epam.javacore.homework_5_upgraded_storage.domain.transportation.Transportation;

public final class Storage {
    private static int ARRAY_CAPCITY = 10;
    private static Cargo[] cargos = new Cargo[ARRAY_CAPCITY];
    private static int cargoIdx = 0;
    private static Transportation[] transportations = new Transportation[ARRAY_CAPCITY];
    private static int transportationsIdx = 0;
    private static Carrier[] carriers = new Carrier[ARRAY_CAPCITY];
    private static int carriersIdx = 0;

    private Storage() {

    }

    public static void addCargo(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargos[cargoIdx++] = cargo;
        if (cargoIdx % (ARRAY_CAPCITY - 1) == 0) {
            copyAndExtendCargos();
        }
    }

    private static void copyAndExtendCargos() {
        Cargo[] dest = new Cargo[cargoIdx + 10];
        System.arraycopy(cargos, 0, dest, 0, cargos.length);
        cargos = dest;
    }

    public static Cargo getCargoById(Long id) {
        if (id == null || id < 0) {
            return null;
        }
        for (Cargo cargo : cargos) {
            if (cargo.getId().equals(id)) {
                return cargo;
            }
        }
        return null;
    }

    public static Cargo getCargoByName(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        for (Cargo cargo : cargos) {
            if (cargo.getName() != null && cargo.getName().equals(name)) {
                return cargo;
            }
        }
        return null;
    }

    public static Cargo[] getCargos() {
        Cargo[] currentCargos = new Cargo[cargoIdx];
        System.arraycopy(cargos, 0, currentCargos, 0, cargoIdx);
        return currentCargos;
    }

    public static void printCargos() {
        System.out.println("There are these cargos in storage:");
        for (Cargo cargo : cargos) {
            if (cargo == null) {
                continue;
            }
            System.out.println(cargo.getName());
        }
        System.out.println("----------------------------------");
    }

    public static void addTransportation(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportations[transportationsIdx++] = transportation;
        if (transportationsIdx % (ARRAY_CAPCITY - 1) == 0) {
            copyAndExtendTransportations();
        }

    }

    private static void copyAndExtendTransportations() {
        Transportation[] dest = new Transportation[transportationsIdx + 10];
        System.arraycopy(transportations, 0, dest, 0, transportations.length);
        transportations = dest;
    }

    public static Transportation getTransportationById(Long id) {
        if (id == null || id < 0) {
            return null;
        }
        for (Transportation transportation : transportations) {
            if (transportation.getId().equals(id)) {
                return transportation;
            }
        }
        return null;
    }

    public static Transportation[] getTransportations() {
        Transportation[] currentTransportations = new Transportation[transportationsIdx];
        System.arraycopy(transportations, 0, currentTransportations, 0, transportationsIdx);
        return currentTransportations;
    }

    public static void printTransportations() {
        System.out.println("There are these transportations in storage:");
        for (Transportation transportation : transportations) {
            if (transportation == null) {
                continue;
            }
            System.out.println(transportation.getBillTo());
        }
        System.out.println("-------------------------------------------");
    }

    public static void addCarrier(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carriers[carriersIdx++] = carrier;
        if (carriersIdx % (ARRAY_CAPCITY - 1) == 0) {
            copyAndExtendCarriers();
        }
    }

    private static void copyAndExtendCarriers() {
        Carrier[] dest = new Carrier[carriersIdx + 10];
        System.arraycopy(carriers, 0, dest, 0, carriers.length);
        carriers = dest;
    }

    public static Carrier getCarrierById(Long id) {
        if (id == null || id < 0) {
            return null;
        }
        for (Carrier carrier : carriers) {
            if (carrier.getId().equals(id)) {
                return carrier;
            }
        }
        return null;
    }

    public static Carrier getCarrierByName(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        for (Carrier carrier : carriers) {
            if (carrier.getName() != null && carrier.getName().equals(name)) {
                return carrier;
            }
        }
        return null;
    }

    public static Carrier[] getCarriers() {
        Carrier[] currentCarriers = new Carrier[carriersIdx];
        System.arraycopy(carriers, 0, currentCarriers, 0, carriersIdx);
        return currentCarriers;
    }

    public static void printCarriers() {
        System.out.println("There are these Carriers:");
        for (Carrier carrier : carriers) {
            if (carrier == null) {
                continue;
            }
            System.out.println(carrier.getName());
        }
        System.out.println("-------------------------");
    }
}

package main.ru.epam.javacore.homework_4_storage.storage;

import main.ru.epam.javacore.homework_4_storage.cargo.Cargo;
import main.ru.epam.javacore.homework_4_storage.carrier.Carrier;
import main.ru.epam.javacore.homework_4_storage.transportation.Transportation;

public class Storage {
    private Cargo[] cargos;
    private Transportation[] transportations;
    private Carrier[] carriers;

    public void addCargo(Cargo cargo) {
        if (this.cargos == null) {
            this.cargos = new Cargo[]{cargo};
        } else {
            Cargo[] tmp = new Cargo[this.cargos.length + 1];
            System.arraycopy(this.cargos, 0, tmp, 0, this.cargos.length);
            tmp[this.cargos.length] = cargo;
            this.cargos = tmp;
        }
    }

    public void addTransportation(Transportation transportation) {
        if (this.transportations == null) {
            this.transportations = new Transportation[]{transportation};
        } else {
            Transportation[] tmp = new Transportation[this.transportations.length + 1];
            System.arraycopy(this.transportations, 0, tmp, 0, this.transportations.length);
            tmp[this.transportations.length] = transportation;
            this.transportations = tmp;
        }
    }

    public void addCarrier(Carrier carrier) {
        if (this.carriers == null) {
            this.carriers = new Carrier[]{carrier};
        } else {
            Carrier[] tmp = new Carrier[this.carriers.length + 1];
            System.arraycopy(this.carriers, 0, tmp, 0, this.carriers.length);
            tmp[this.carriers.length] = carrier;
            this.carriers = tmp;
        }
    }

    public void printCargos() {
        if (this.cargos == null) {
            System.out.println("There are no cargos!");
        } else {
            System.out.println("There are these cargos in storage:");
            for (Cargo cargo : this.cargos) {
                System.out.println(cargo.getName());
            }
            System.out.println("----------------------------------");
        }
    }

    public void printTransportations() {
        if (this.transportations == null) {
            System.out.println("There are no transportations!");
        } else {
            System.out.println("There are these transportations in storage:");
            for (Transportation transportation : this.transportations) {
                System.out.println(transportation.getBillTo());
            }
            System.out.println("-------------------------------------------");
        }
    }

    public void printCarriers() {
        if (this.carriers == null) {
            System.out.println("There are no carriers!");
        } else {
            System.out.println("There are these Carriers:");
            for (Carrier carrier : this.carriers) {
                System.out.println(carrier.getName());
            }
            System.out.println("-------------------------");
        }
    }
}

package main.ru.epam.javacore.homework_5_upgraded_storage.domain.cargo;

import main.ru.epam.javacore.homework_5_upgraded_storage.domain.Domain;
import main.ru.epam.javacore.homework_5_upgraded_storage.domain.transportation.Transportation;

public class Cargo extends Domain {
    private String name;
    private int weight;
    private CargoType cargoType;
    private Transportation[] transportations;

    public Cargo() {

    }

    public Cargo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public Transportation[] getTransportations() {
        return transportations;
    }

    public void setTransportations(Transportation[] transportations) {
        this.transportations = transportations;
    }
}

package ru.epam.javacore.homework_4_storage.cargo;

import ru.epam.javacore.homework_4_storage.transportation.Transportation;

public class Cargo {
    private static Long counter = 0L;
    private Long id;
    private String name;
    private int weight;
    private CargoType cargoType;
    private Transportation[] transportations;

    public Cargo() {
        this.id = counter++;
    }

    public Cargo(String name) {
        this();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

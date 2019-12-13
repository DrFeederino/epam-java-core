package ru.epam.javacore.homework_5_upgraded_storage.domain.carrier;

import ru.epam.javacore.homework_5_upgraded_storage.domain.Domain;
import ru.epam.javacore.homework_5_upgraded_storage.domain.transportation.Transportation;

public class Carrier extends Domain {
    private String name;
    private String address;
    private CarrierType carrierType;
    private Transportation[] transportations;

    public Carrier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CarrierType getCarrierType() {
        return carrierType;
    }

    public void setCarrierType(CarrierType carrierType) {
        this.carrierType = carrierType;
    }

    public Transportation[] getTransportations() {
        return transportations;
    }

    public void setTransportations(Transportation[] transportations) {
        this.transportations = transportations;
    }
}

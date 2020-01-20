package main.ru.epam.javacore.homework_4_storage.carrier;

import main.ru.epam.javacore.homework_4_storage.transportation.Transportation;

public class Carrier {
    private static Long counter = 0L;
    private Long id;
    private String name;
    private String address;
    private CarrierType carrierType;
    private Transportation[] transportations;

    public Carrier() {
        this.id = counter++;
    }

    public Carrier(String name) {
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

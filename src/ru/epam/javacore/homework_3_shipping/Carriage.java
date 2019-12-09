package ru.epam.javacore.homework_3_shipping;

import java.util.Date;

public class Carriage {
    private Carrier carrier;
    private Person receiver;
    private Date dateOfSending;
    private String trackingNumber;
    private Cargo cargo;

    public Carriage(Carrier carrier, Person receiver, Date dateOfSending, String trackingNumber, Cargo cargo) {
        this.carrier = carrier;
        this.receiver = receiver;
        this.dateOfSending = dateOfSending;
        this.trackingNumber = trackingNumber;
        this.cargo = cargo;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Person getReceiver() {
        return receiver;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public Date getDateOfSending() {
        return dateOfSending;
    }

    public void setDateOfSending(Date dateOfSending) {
        this.dateOfSending = dateOfSending;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}

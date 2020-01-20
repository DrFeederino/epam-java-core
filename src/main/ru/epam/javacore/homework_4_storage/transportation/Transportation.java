package main.ru.epam.javacore.homework_4_storage.transportation;

import main.ru.epam.javacore.homework_4_storage.cargo.Cargo;
import main.ru.epam.javacore.homework_4_storage.carrier.Carrier;

import java.util.Date;

public class Transportation {
    private static Long counter = 0L;
    private Long id;
    private Cargo cargo;
    private Carrier carrier;
    private String description;
    private String billTo;
    private Date date;

    public Transportation() {
        this.id = counter++;
    }

    public Transportation(String billTo) {
        this();
        this.billTo = billTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }
}

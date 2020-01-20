package main.ru.epam.javacore.homework_5_upgraded_storage.domain.transportation;

import main.ru.epam.javacore.homework_5_upgraded_storage.domain.Domain;
import main.ru.epam.javacore.homework_5_upgraded_storage.domain.cargo.Cargo;
import main.ru.epam.javacore.homework_5_upgraded_storage.domain.carrier.Carrier;

import java.util.Date;

public class Transportation extends Domain {
    private Cargo cargo;
    private Carrier carrier;
    private String description;
    private String billTo;
    private Date date;

    public Transportation(String billTo) {
        this.billTo = billTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

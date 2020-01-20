package main.ru.epam.javacore.homework_3_shipping;

public class Carrier {
    private Person carrierInfo;
    private String status;

    public Carrier(Person carrierInfo, String status) {
        this.carrierInfo = carrierInfo;
        this.status = status;
    }

    public Person getCarrierInfo() {
        return carrierInfo;
    }

    public void setCarrierInfo(Person carrierInfo) {
        this.carrierInfo = carrierInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

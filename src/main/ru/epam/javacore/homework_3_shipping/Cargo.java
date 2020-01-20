package main.ru.epam.javacore.homework_3_shipping;

public class Cargo {
    private String name;
    private String[] items;
    private CargoInfo info;

    public Cargo(String name, String[] items, CargoInfo info) {
        this.name = name;
        this.items = items;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public CargoInfo getInfo() {
        return info;
    }

    public void setInfo(CargoInfo info) {
        this.info = info;
    }
}

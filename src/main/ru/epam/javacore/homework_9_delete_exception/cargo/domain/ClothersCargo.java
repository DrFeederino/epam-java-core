package main.ru.epam.javacore.homework_9_delete_exception.cargo.domain;

public class ClothersCargo extends Cargo {

    private String size;
    private String material;

    @Override
    public CargoType getCargoType() {
        return CargoType.CLOTHERS;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

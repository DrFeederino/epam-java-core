package main.ru.epam.javacore.homework_3_shipping;

public class CargoInfo {
    private boolean isFragile;
    private float[] dimensions;
    private float weight;

    public CargoInfo(boolean isFragile, float[] dimensions, float weight) {
        this.isFragile = isFragile;
        this.dimensions = dimensions;
        this.weight = weight;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public float[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(float[] dimensions) {
        this.dimensions = dimensions;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

}

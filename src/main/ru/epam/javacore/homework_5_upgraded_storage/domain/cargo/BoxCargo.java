package main.ru.epam.javacore.homework_5_upgraded_storage.domain.cargo;

public class BoxCargo extends Cargo {
    private float[] dimensions;

    public BoxCargo(float[] dimensions) {
        this.dimensions = dimensions;
    }

    public BoxCargo(String name, float[] dimensions) {
        super(name);
        this.dimensions = dimensions;
    }

    public void calculateVolume() {
        float result = 1;
        for (float dimension : dimensions) {
            result *= dimension;
        }
        System.out.println("Box's volume is " + result);
    }

    public float[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(float[] dimensions) {
        this.dimensions = dimensions;
    }
}

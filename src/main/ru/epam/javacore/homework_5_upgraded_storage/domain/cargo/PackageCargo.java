package main.ru.epam.javacore.homework_5_upgraded_storage.domain.cargo;

public class PackageCargo extends Cargo {
    private final float RATE_PER_HUNDRED = 0.99f;
    private float cost;

    public PackageCargo(float insurance) {
        this.cost = insurance;
    }

    public PackageCargo(String name, float insurance) {
        super(name);
        this.cost = insurance;
    }

    public void calculateInsurance() {
        int hundreds = (int) Math.floor(cost / 100 + 1);
        float insuranceCost = hundreds * RATE_PER_HUNDRED;
        System.out.println("Insurance would cost " + insuranceCost);
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getRATE_PER_HUNDRED() {
        return RATE_PER_HUNDRED;
    }
}

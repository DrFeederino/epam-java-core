package ru.epam.javacore.homework_2_quadratic_equations_class;

public class QuadraticEquations {
    private double discriminant;
    private float a;
    private float b;
    private float c;

    public QuadraticEquations(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.discriminant = solve();
    }

    public double solve() {
        discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("No real roots.");
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Root is " + x + ".");
        } else {
            double x1 = (-b + Math.sqrt(this.discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(this.discriminant)) / (2 * a);
            System.out.print("\nFirst root is " + x1);
            System.out.println(", second root is " + x2 + ".");
        }
        return discriminant;
    }

    public double getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(double discriminant) {
        this.discriminant = discriminant;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "QuadraticEquations{" +
                "discriminant=" + discriminant +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}

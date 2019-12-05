package ru.epam.javacore.homework_2_quadratic_equations_class;

public class QuadraticEquations {
    private double discriminant;
    private Coefficient a;
    private Coefficient b;
    private Coefficient c;

    public QuadraticEquations(Coefficient a, Coefficient b, Coefficient c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double solve() {
        if (a == null || b == null || c == null) {
            System.out.println("One of the coefficient is set to null!");
        } else {
            discriminant = Math.pow(b.getValue(), 2) - 4 * a.getValue() * c.getValue();

            if (discriminant < 0) {
                System.out.println("No real roots.");
            } else if (discriminant == 0) {
                double x = -b.getValue() / (2 * a.getValue());
                System.out.println("Root is " + x + ".");
            } else {
                double x1 = (-b.getValue() + Math.sqrt(this.discriminant)) / (2 * a.getValue());
                double x2 = (-b.getValue() - Math.sqrt(this.discriminant)) / (2 * a.getValue());
                System.out.print("\nFirst root is " + x1);
                System.out.println(", second root is " + x2 + ".");
            }
        }
        return discriminant;
    }

    public double getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(double discriminant) {
        this.discriminant = discriminant;
    }

    public Coefficient getA() {
        return a;
    }

    public void setA(Coefficient a) {
        this.a = a;
    }

    public Coefficient getB() {
        return b;
    }

    public void setB(Coefficient b) {
        this.b = b;
    }

    public Coefficient getC() {
        return c;
    }

    public void setC(Coefficient c) {
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

package ru.epam.javacore.homework_1_quadratic_equaitons;

public class Equations {

    public static void solveQuadraticEquation(float a, float b, float c) {
        double discriminant;

        discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("No real roots.");
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Root is " + x + ".");
        } else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.print("\nFirst root is " + x1);
            System.out.println(", second root is " + x2 + ".");
        }

    }
}

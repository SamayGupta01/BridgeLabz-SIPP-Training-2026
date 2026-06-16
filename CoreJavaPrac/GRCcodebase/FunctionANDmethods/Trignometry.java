package GRCcodebase.FunctionANDmethods;

import java.util.Scanner;

public class Trignometry {

    public static double[] calculateTrigonometricFunctions(double angle) {
        double rad = Math.toRadians(angle);

        return new double[]{
                Math.sin(rad),
                Math.cos(rad),
                Math.tan(rad)
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double angle = sc.nextDouble();

        double[] result = calculateTrigonometricFunctions(angle);

        System.out.println("Sin = " + result[0]);
        System.out.println("Cos = " + result[1]);
        System.out.println("Tan = " + result[2]);
    }
}
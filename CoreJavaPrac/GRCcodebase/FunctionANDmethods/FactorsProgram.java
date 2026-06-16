package GRCcodebase.FunctionANDmethods;

import java.util.Scanner;

public class FactorsProgram {

    public static int[] findFactors(int number) {
        int count = 0;

        // Count factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        // Store factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    public static int findSum(int[] factors) {
        int sum = 0;

        for (int factor : factors) {
            sum += factor;
        }

        return sum;
    }

    public static long findProduct(int[] factors) {
        long product = 1;

        for (int factor : factors) {
            product *= factor;
        }

        return product;
    }

    public static double findSumOfSquares(int[] factors) {
        double sum = 0;

        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }

        System.out.println("\nSum = " + findSum(factors));
        System.out.println("Product = " + findProduct(factors));
        System.out.println("Sum of Squares = " + findSumOfSquares(factors));
    }
}
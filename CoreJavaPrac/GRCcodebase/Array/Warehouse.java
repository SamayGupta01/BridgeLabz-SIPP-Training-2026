package GRCcodebase.Array;

import java.util.HashSet;

public class Warehouse {

    public static void main(String[] args) {

        int[] stock = {50, 20, 80, 20, 60, 90, 50};
        int k = 2;

        // Max, Min, Total
        int max = stock[0];
        int min = stock[0];
        int total = 0;

        for (int qty : stock) {
            if (qty > max)
                max = qty;

            if (qty < min)
                min = qty;

            total += qty;
        }

        System.out.println("Maximum Stock = " + max);
        System.out.println("Minimum Stock = " + min);
        System.out.println("Total Stock = " + total);

        // Detect Duplicates
        HashSet<Integer> set = new HashSet<>();

        System.out.print("Duplicate Quantities: ");

        for (int qty : stock) {
            if (!set.add(qty)) {
                System.out.print(qty + " ");
            }
        }

        System.out.println();

        // Rotate Array by k positions
        rotate(stock, k);

        System.out.print("Array after rotation: ");
        for (int qty : stock) {
            System.out.print(qty + " ");
        }

        System.out.println();

        // 2D Shelf Grid
        int[][] shelf = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("\nOriginal Shelf Grid:");
        printMatrix(shelf);

        int[][] transpose = transpose(shelf);

        System.out.println("\nTransposed Shelf Grid:");
        printMatrix(transpose);
    }

    static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    static int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

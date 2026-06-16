package GRCcodebase.Recursion;

import java.util.Scanner;

public class Power {
    static long power(int x, int n) {
        if (n == 0)
            return 1;

        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(power(x, n));
    }
}
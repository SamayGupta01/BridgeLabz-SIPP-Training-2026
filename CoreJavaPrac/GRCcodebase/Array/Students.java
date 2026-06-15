package GRCcodebase.Array;

import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[10];

        System.out.println("Enter ages of 10 students:");

        for (int i = 0; i < ages.length; i++) {
            System.out.print("Age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }

        System.out.println("\nVoting Eligibility:");

        for (int age : ages) {
            if (age < 0) {
                System.out.println("Invalid age: " + age);
            } else if (age >= 18) {
                System.out.println("The student with age " + age + " can vote.");
            } else {
                System.out.println("The student with age " + age + " cannot vote.");
            }
        }

        sc.close();
    }
}

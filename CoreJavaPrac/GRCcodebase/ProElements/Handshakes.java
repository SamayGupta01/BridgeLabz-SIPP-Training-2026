package CoreJavaPrac.GRCcodebase.ProElements;

import java.util.Scanner;

public class Handshakes {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int numberOfStudents = input.nextInt();

            int handshakes = (numberOfStudents *
                    (numberOfStudents - 1)) / 2;

            System.out.println("The maximum number of handshakes is "
                    + handshakes);
        }
    }
}
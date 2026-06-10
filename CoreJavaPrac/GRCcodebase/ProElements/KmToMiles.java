package CoreJavaPrac.GRCcodebase.ProElements;
import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            double km = input.nextDouble();

            double miles = km / 1.6;

            System.out.println("The total miles is " + miles +
                    " mile for the given " + km + " km");
        }
    }
}
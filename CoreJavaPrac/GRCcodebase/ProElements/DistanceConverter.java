package CoreJavaPrac.GRCcodebase.ProElements;
import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            double feet = input.nextDouble();

            double yards = feet / 3;
            double miles = yards / 1760;

            System.out.println("Distance in yards is " +
                    yards + " and distance in miles is " + miles);
        }
    }
}
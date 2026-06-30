import java.util.Scanner;

public class PackageDemo {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome — Express Shipment Creator");
            System.out.println("You will be prompted to enter shipment details.");

            System.out.print("Enter tracking ID (e.g. EXP101): ");
            String trackingId = sc.nextLine().trim();
            if (trackingId.isEmpty()) trackingId = "EXP000";

            double weight = readPositiveDouble(sc, "Enter weight in kg (e.g. 2.5): ");

            System.out.print("Enter priority (Normal / High / Critical) [Normal]: ");
            String priority = sc.nextLine().trim();
            if (priority.isEmpty()) priority = "Normal";

            ExpressPackage shipment = new ExpressPackage(trackingId, weight, priority);
            System.out.println();
            System.out.println("--- Created Shipment ---");
            shipment.printShippingLabel();

            while (true) {
                System.out.print("Do you want to update the weight? (y/n): ");
                String ans = sc.nextLine().trim().toLowerCase();
                if (ans.equals("y") || ans.equals("yes")) {
                    double newWeight = readDouble(sc, "Enter new weight (kg): ");
                    shipment.setWeight(newWeight);
                    System.out.println("Current shipment details:");
                    shipment.printShippingLabel();
                } else {
                    break;
                }
            }

            System.out.println();
            System.out.println("=== Final Shipment Details ===");
            shipment.printShippingLabel();
            System.out.println("Goodbye.");
        }
    }

    private static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static double readPositiveDouble(Scanner sc, String prompt) {
        while (true) {
            double v = readDouble(sc, prompt);
            if (v <= 0.0) {
                System.out.println("Weight must be greater than 0. Please try again.");
                continue;
            }
            return v;
        }
    }
}

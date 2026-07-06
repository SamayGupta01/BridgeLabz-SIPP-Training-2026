import java.util.ArrayList;
import java.util.Scanner;

public class SmartParkingSlotManager {
    private static final ArrayList<String> parkedVehicles = new ArrayList<>();

    public static void enterVehicle(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println("Vehicle is already parked.");
            return;
        }

        parkedVehicles.add(registrationNumber);
        System.out.println("Vehicle parked successfully.");
    }

    public static void exitVehicle(String registrationNumber) {
        if (parkedVehicles.remove(registrationNumber)) {
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public static void searchVehicle(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println("Vehicle is currently parked.");
        } else {
            System.out.println("Vehicle is not parked.");
        }
    }

    public static void displayVehicles() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles are currently parked.");
            return;
        }

        System.out.println("Parked vehicles:");
        for (String vehicle : parkedVehicles) {
            System.out.println(vehicle);
        }
        System.out.println("Total occupied slots: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Enter Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Display Vehicles");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter registration number: ");
                    enterVehicle(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter registration number: ");
                    exitVehicle(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter registration number: ");
                    searchVehicle(scanner.nextLine());
                    break;
                case 4:
                    displayVehicles();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

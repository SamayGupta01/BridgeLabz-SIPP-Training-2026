import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SmartCityTrafficMonitoringSystem {
    private static final HashMap<String, Integer> vehicleCounts = new HashMap<>();

    public static void addOrUpdateRoad(String roadName, int count) {
        vehicleCounts.put(roadName, count);
        System.out.println("Vehicle count saved successfully.");
    }

    public static void displaySortedRoads() {
        if (vehicleCounts.isEmpty()) {
            System.out.println("No roads are being monitored.");
            return;
        }

        TreeMap<String, Integer> sortedRoads = new TreeMap<>(vehicleCounts);
        for (Map.Entry<String, Integer> entry : sortedRoads.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " vehicles");
        }
    }

    public static void displayBusiestRoad() {
        if (vehicleCounts.isEmpty()) {
            System.out.println("No roads are being monitored.");
            return;
        }

        String busiestRoad = "";
        int highestCount = -1;

        for (Map.Entry<String, Integer> entry : vehicleCounts.entrySet()) {
            if (entry.getValue() > highestCount) {
                busiestRoad = entry.getKey();
                highestCount = entry.getValue();
            }
        }

        System.out.println("Busiest road: " + busiestRoad + " with " + highestCount + " vehicles");
    }

    public static void generateReport() {
        displaySortedRoads();
        displayBusiestRoad();
        System.out.println("Total roads monitored: " + vehicleCounts.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add or Update Road Count");
            System.out.println("2. Display Roads Sorted By Name");
            System.out.println("3. Display Busiest Road");
            System.out.println("4. Generate Traffic Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter road name: ");
                    String roadName = scanner.nextLine();
                    System.out.print("Enter vehicle count: ");
                    int count = scanner.nextInt();
                    scanner.nextLine();
                    addOrUpdateRoad(roadName, count);
                    break;
                case 2:
                    displaySortedRoads();
                    break;
                case 3:
                    displayBusiestRoad();
                    break;
                case 4:
                    generateReport();
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

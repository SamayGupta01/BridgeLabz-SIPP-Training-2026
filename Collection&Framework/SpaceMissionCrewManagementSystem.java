import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Astronaut {
    String astronautId;
    String name;
    String specialization;

    Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return astronautId + " - " + name + " (" + specialization + ")";
    }
}

public class SpaceMissionCrewManagementSystem {
    private static final HashMap<String, List<Astronaut>> missionCrews = new HashMap<>();
    private static final HashMap<String, HashSet<String>> assignedIdsByMission = new HashMap<>();

    public static void addMission(String missionName) {
        if (missionCrews.containsKey(missionName)) {
            System.out.println("Mission already exists.");
            return;
        }

        missionCrews.put(missionName, new ArrayList<>());
        assignedIdsByMission.put(missionName, new HashSet<>());
        System.out.println("Mission added successfully.");
    }

    public static void assignAstronaut(String missionName, Astronaut astronaut) {
        if (!missionCrews.containsKey(missionName)) {
            addMission(missionName);
        }

        HashSet<String> assignedIds = assignedIdsByMission.get(missionName);
        if (!assignedIds.add(astronaut.astronautId)) {
            System.out.println("Astronaut is already assigned to this mission.");
            return;
        }

        missionCrews.get(missionName).add(astronaut);
        System.out.println("Astronaut assigned successfully.");
    }

    public static void displayMissions() {
        if (missionCrews.isEmpty()) {
            System.out.println("No missions available.");
            return;
        }

        for (String missionName : missionCrews.keySet()) {
            List<Astronaut> crew = missionCrews.get(missionName);
            System.out.println("\nMission: " + missionName);
            for (Astronaut astronaut : crew) {
                System.out.println(astronaut);
            }
            System.out.println("Total astronauts: " + crew.size());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Mission");
            System.out.println("2. Assign Astronaut");
            System.out.println("3. Display Missions");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter mission name: ");
                    addMission(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter mission name: ");
                    String missionName = scanner.nextLine();
                    System.out.print("Enter astronaut id: ");
                    String astronautId = scanner.nextLine();
                    System.out.print("Enter astronaut name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter specialization: ");
                    String specialization = scanner.nextLine();
                    assignAstronaut(missionName, new Astronaut(astronautId, name, specialization));
                    break;
                case 3:
                    displayMissions();
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

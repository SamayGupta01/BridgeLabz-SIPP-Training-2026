import java.util.HashSet;
import java.util.Scanner;

public class EventEntryVerificationSystem {
    private static final HashSet<String> participants = new HashSet<>();

    public static void registerParticipant(String email) {
        if (participants.add(email.toLowerCase())) {
            System.out.println("Participant registered successfully.");
        } else {
            System.out.println("Duplicate registration rejected.");
        }
    }

    public static void displayParticipants() {
        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
            return;
        }

        System.out.println("Unique registered participants:");
        for (String email : participants) {
            System.out.println(email);
        }
        System.out.println("Total eligible attendees: " + participants.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register Participant");
            System.out.println("2. Display Participants");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter email id: ");
                    registerParticipant(scanner.nextLine());
                    break;
                case 2:
                    displayParticipants();
                    break;
                case 3:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

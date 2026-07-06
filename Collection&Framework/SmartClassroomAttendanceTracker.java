import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SmartClassroomAttendanceTracker {
    private static final HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    public static void markAttendance(String subject, String studentName) {
        attendance.putIfAbsent(subject, new ArrayList<>());
        ArrayList<String> students = attendance.get(subject);

        if (students.contains(studentName)) {
            System.out.println("Duplicate attendance is not allowed for this subject.");
            return;
        }

        students.add(studentName);
        System.out.println("Attendance marked successfully.");
    }

    public static void displayAttendance() {
        if (attendance.isEmpty()) {
            System.out.println("No attendance records available.");
            return;
        }

        for (String subject : attendance.keySet()) {
            ArrayList<String> students = attendance.get(subject);
            System.out.println("\nSubject: " + subject);
            for (String student : students) {
                System.out.println(student);
            }
            System.out.println("Total present: " + students.size());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Mark Attendance");
            System.out.println("2. Display Attendance");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter subject name: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String student = scanner.nextLine();
                    markAttendance(subject, student);
                    break;
                case 2:
                    displayAttendance();
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

// Problem 4: Smart Library Membership System Demo
// Demonstrates dynamic method dispatch for calculating fines and member management

public class SmartLibraryMembershipSystem {
    
    public static void calculateAndDisplayFines(LibraryMember[] members, int overdueDays) {
        System.out.println("════════════════════════════════════════════════════════");
        System.out.println("       LIBRARY MEMBERSHIP - FINE CALCULATION SYSTEM");
        System.out.println("════════════════════════════════════════════════════════");
        System.out.println("Overdue Days: " + overdueDays + "\n");
        
        double totalFines = 0;
        int studentCount = 0, facultyCount = 0, guestCount = 0;
        
        for (LibraryMember member : members) {
            // Dynamic method dispatch - appropriate calculateFine() called
            double fine = member.calculateFine(overdueDays);
            totalFines += fine;
            
            // Count membership types
            if (member instanceof StudentMember) {
                System.out.println("[STUDENT] STUDENT MEMBER");
                studentCount++;
            } else if (member instanceof FacultyMember) {
                System.out.println("[FACULTY] FACULTY MEMBER");
                facultyCount++;
            } else if (member instanceof GuestMember) {
                System.out.println("[GUEST] GUEST MEMBER");
                guestCount++;
            }
            
            System.out.println("---------------------------------------------------------------------------");
            member.printDetails();
            System.out.println("Fine for " + overdueDays + " days: Rs." + String.format("%.2f", fine));
            System.out.println("=========================================================================\n");
        }
        
        System.out.println("==========================================================================");
        System.out.println("              SYSTEM SUMMARY");
        System.out.println("==========================================================================");
        System.out.println("Total Members: " + members.length);
        System.out.println("[STUDENT] Student Members: " + studentCount);
        System.out.println("[FACULTY] Faculty Members: " + facultyCount);
        System.out.println("[GUEST] Guest Members: " + guestCount);
        System.out.println("\nTotal Fines Collected: Rs." + String.format("%.2f", totalFines));
    }
    
    public static LibraryMember findMemberById(LibraryMember[] members, String memberId) {
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        // Create multiple library members of different types
        LibraryMember[] members = {
            new StudentMember("Raj Patel", "STU001", "BITS Pilani"),
            new FacultyMember("Dr. Sharma", "FAC001", "Computer Science"),
            new GuestMember("Guest User 1", "GUEST001", "Stanford University"),
            new StudentMember("Priya Nair", "STU002", "IIT Bombay"),
            new FacultyMember("Prof. Verma", "FAC002", "Physics Department"),
            new GuestMember("Guest User 2", "GUEST002", "Harvard University")
        };
        
        // Calculate and display fines for 5 overdue days
        calculateAndDisplayFines(members, 5);
        
        // Find and display specific member details
        System.out.println("\n════════════════════════════════════════════════════════");
        System.out.println("       SEARCHING FOR SPECIFIC MEMBER");
        System.out.println("════════════════════════════════════════════════════════\n");
        
        String searchId = "STU002";
        LibraryMember foundMember = findMemberById(members, searchId);
        
        if (foundMember != null) {
            System.out.println("✓ Member Found!\n");
            foundMember.printDetails();
        } else {
            System.out.println("✗ Member with ID " + searchId + " not found!");
        }
    }
}

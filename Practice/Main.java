package Practice;

class Student {
    String name;
    int rollNumber;
    double marks;

    // Constructor
    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("Name: " + name + ", Roll Number: " + rollNumber + ", Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Alice", 101, 89.5);
        student.displayDetails();  // Output: Name: Alice, Roll Number: 101, Marks: 89.5
    }
}


Program 2: Travel Details
class TravelDetails {
    String fromCity, toCity;
    double distance;

    // Constructor
    TravelDetails(String fromCity, String toCity, double distance) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    // Method to display travel information
    void displayTravelInfo() {
        System.out.println("Traveling from " + fromCity + " to " + toCity + " covers " + distance + " km.");
    }
}

public class Main {
    public static void main(String[] args) {
        TravelDetails travel = new TravelDetails("Chennai", "Bangalore", 345.6);
        travel.displayTravelInfo();  // Output: Traveling from Chennai to Bangalore covers 345.6 km.
    }
}





package oops.interfaces;

/**
 * Problem 1: Fitness Tracker
 * Demonstrates multiple interface implementation in Java
 * Interfaces: Trackable, Reportable, Notifiable
 * Class: FitnessDevice implements all three interfaces
 */

// Interface 1: Trackable with default method
interface Trackable {
    void logActivity(String activity, double value);
    
    // Default method - can be overridden by implementing classes
    default void resetData() {
        System.out.println("Resetting all tracked data...");
    }
}

// Interface 2: Reportable
interface Reportable {
    void generateReport();
}

// Interface 3: Notifiable
interface Notifiable {
    void sendAlert(String message);
}

// Class implementing all three interfaces
class FitnessDevice implements Trackable, Reportable, Notifiable {
    private double stepCount = 0;
    private double caloriesBurned = 0;
    private double distanceWalked = 0;
    private String[] activities = new String[100];
    private int activityCount = 0;
    
    @Override
    public void logActivity(String activity, double value) {
        if (activity.equalsIgnoreCase("steps")) {
            stepCount += value;
        } else if (activity.equalsIgnoreCase("calories")) {
            caloriesBurned += value;
        } else if (activity.equalsIgnoreCase("distance")) {
            distanceWalked += value;
        }
        
        if (activityCount < 100) {
            activities[activityCount++] = activity + ": " + value;
        }
        System.out.println("✓ Logged: " + activity + " = " + value);
    }
    
    @Override
    public void generateReport() {
        System.out.println("\n========== DAILY FITNESS REPORT ==========");
        System.out.println("Total Steps: " + stepCount);
        System.out.println("Calories Burned: " + caloriesBurned);
        System.out.println("Distance Walked: " + distanceWalked + " km");
        System.out.println("\nActivity History:");
        for (int i = 0; i < activityCount; i++) {
            System.out.println("  - " + activities[i]);
        }
        System.out.println("==========================================\n");
    }
    
    @Override
    public void sendAlert(String message) {
        System.out.println("🔔 ALERT: " + message);
    }
    
    // Overriding the default method from Trackable interface
    @Override
    public void resetData() {
        stepCount = 0;
        caloriesBurned = 0;
        distanceWalked = 0;
        activityCount = 0;
        System.out.println("✓ All data has been reset successfully!");
    }
    
    public void checkGoals() {
        if (stepCount >= 10000) {
            sendAlert("Daily step goal reached!");
        }
        if (caloriesBurned >= 500) {
            sendAlert("Daily calorie goal reached!");
        }
    }
}

public class FitnessTracker {
    public static void main(String[] args) {
        System.out.println("===== FITNESS TRACKER DEMO =====\n");
        
        FitnessDevice device = new FitnessDevice();
        
        // Demonstrating interface implementation
        System.out.println("1. Logging activities (Trackable interface):");
        device.logActivity("steps", 8500);
        device.logActivity("calories", 450);
        device.logActivity("distance", 5.2);
        device.logActivity("steps", 2000);
        
        System.out.println("\n2. Checking fitness goals (Notifiable interface):");
        device.checkGoals();
        
        System.out.println("\n3. Generating report (Reportable interface):");
        device.generateReport();
        
        System.out.println("4. Using default method from Trackable:");
        device.resetData();
        
        System.out.println("\n5. Continuing after reset:");
        device.logActivity("steps", 3000);
        device.logActivity("calories", 200);
        device.generateReport();
        
        System.out.println("\nKey Points Demonstrated:");
        System.out.println("✓ Multiple interface implementation");
        System.out.println("✓ Default methods in interfaces");
        System.out.println("✓ Method overriding");
        System.out.println("✓ Polymorphism with interfaces");
    }
}

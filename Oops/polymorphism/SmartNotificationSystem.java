// Problem 2: Smart Notification System Demo
// Demonstrates dynamic method dispatch for sending notifications through different channels

public class SmartNotificationSystem {
    
    public static void sendAllNotifications(Notification[] notifications) {
        System.out.println("===============================================");
        System.out.println("       SMART NOTIFICATION SYSTEM - BATCH SEND");
        System.out.println("===============================================\n");
        
        int emailCount = 0, smsCount = 0, pushCount = 0;
        
        for (Notification notification : notifications) {
            // Dynamic method dispatch - appropriate sendNotification() method called
            notification.sendNotification();
            
            // Count notification types
            if (notification instanceof EmailNotification) {
                emailCount++;
            } else if (notification instanceof SMSNotification) {
                smsCount++;
            } else if (notification instanceof PushNotification) {
                pushCount++;
            }
        }
        
        System.out.println("\n===============================================");
        System.out.println("              NOTIFICATION SUMMARY");
        System.out.println("===============================================");
        System.out.println("Total Notifications Sent: " + notifications.length);
        System.out.println("[EMAIL] Email Notifications:  " + emailCount);
        System.out.println("[SMS] SMS Notifications:    " + smsCount);
        System.out.println("[PUSH] Push Notifications:   " + pushCount);
    }
    
    public static void main(String[] args) {
        // Create multiple notification objects of different types
        Notification[] notifications = {
            new EmailNotification("Amit Kumar", "Your order #12345 has been shipped"),
            new SMSNotification("Priya Sharma", "OTP: 456789"),
            new PushNotification("Rahul Singh", "You have a new message from support team"),
            new EmailNotification("Neha Patel", "Welcome to our service! Please verify your email"),
            new SMSNotification("Arjun Verma", "Your balance is low. Please recharge"),
            new PushNotification("Deepak Roy", "New feature available: Check out our latest updates")
        };
        
        // Send all notifications using dynamic method dispatch
        sendAllNotifications(notifications);
    }
}

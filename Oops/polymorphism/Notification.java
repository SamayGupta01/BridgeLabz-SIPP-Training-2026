// Problem 2: Smart Notification System
// Superclass Notification

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Notification {
    protected String recipientName;
    protected String message;
    protected LocalDateTime sentTime;
    
    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
        this.sentTime = LocalDateTime.now();
    }
    
    // Abstract method - each notification type sends differently
    public abstract void sendNotification();
    
    // Display common details
    protected void displayDetails(String channel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("[" + formatter.format(sentTime) + "] [" + channel + "] " +
                         "To: " + recipientName + " | Message: " + message);
    }
    
    public String getRecipientName() {
        return recipientName;
    }
    
    public String getMessage() {
        return message;
    }
}

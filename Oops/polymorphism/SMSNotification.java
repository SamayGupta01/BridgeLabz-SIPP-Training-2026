// SMSNotification subclass

public class SMSNotification extends Notification {
    
    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }
    
    @Override
    public void sendNotification() {
        System.out.print("[SMS] SMS SENT - ");
        displayDetails("SMS");
        String truncatedMsg = message.length() > 50 ? message.substring(0, 47) + "..." : message;
        System.out.println("   -> Character count: " + truncatedMsg.length() + " (Max: 160)");
    }
}

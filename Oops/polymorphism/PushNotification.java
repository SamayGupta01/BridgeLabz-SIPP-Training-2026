// PushNotification subclass

public class PushNotification extends Notification {
    
    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }
    
    @Override
    public void sendNotification() {
        System.out.print("[PUSH] PUSH NOTIFICATION SENT - ");
        displayDetails("PUSH");
        System.out.println("   -> Delivered to mobile devices and web browsers");
    }
}

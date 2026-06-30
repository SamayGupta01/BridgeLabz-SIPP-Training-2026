public class ExpressPackage extends Package {
    private final String priorityLevel;

    public ExpressPackage(String trackingId, double weight, String priorityLevel) {
        super(trackingId, weight);
        this.priorityLevel = priorityLevel;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void printShippingLabel() {
        System.out.println("Express Package Shipping Label");
        System.out.println("------------------------------");
        System.out.println("Tracking ID   : " + getTrackingId());
        System.out.println("Weight (kg)   : " + getWeight());
        System.out.println("Priority Level: " + getPriorityLevel());
        System.out.println("------------------------------");
    }
}

public class Package {
    private final String trackingId;
    private double weight;

    public Package(String trackingId, double weight) {
        this.trackingId = trackingId;
        if (weight <= 0.0) {
            System.out.println("Error: Invalid weight " + weight + ". Weight must be greater than 0.0.");
            this.weight = 0.0;
        } else {
            this.weight = weight;
        }
    }

    public String getTrackingId() {
        return trackingId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0.0) {
            System.out.println("Error: Weight update rejected. Weight must be greater than 0.0.");
            return;
        }
        this.weight = weight;
        System.out.println("Weight updated to " + this.weight + " kg.");
    }
}

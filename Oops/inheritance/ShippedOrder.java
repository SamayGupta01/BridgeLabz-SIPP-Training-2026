package oops.inheritance;

public class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Shipped";
    }

    @Override
    public String toString() {
        return "ShippedOrder{" + super.toString() + ", trackingNumber='" + trackingNumber + "'}";
    }
}

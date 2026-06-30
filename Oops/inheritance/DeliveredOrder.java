package oops.inheritance;

public class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Delivered";
    }

    @Override
    public String toString() {
        return "DeliveredOrder{" + super.toString() + ", deliveryDate='" + deliveryDate + "'}";
    }
}

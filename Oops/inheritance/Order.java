package oops.inheritance;

public class Order {
    private String orderId;
    private String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return "Order placed";
    }

    @Override
    public String toString() {
        return "Order{orderId='" + orderId + "', orderDate='" + orderDate + "', status='" + getOrderStatus() + "'}";
    }
}

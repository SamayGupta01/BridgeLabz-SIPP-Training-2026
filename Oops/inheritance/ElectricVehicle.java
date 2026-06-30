package oops.inheritance;

public class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging " + getModel() + " with " + batteryCapacity + " kWh battery.");
    }

    @Override
    public String toString() {
        return "ElectricVehicle{" + super.toString() + ", batteryCapacity=" + batteryCapacity + "}";
    }
}

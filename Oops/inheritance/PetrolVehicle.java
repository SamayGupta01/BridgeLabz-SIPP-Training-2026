package oops.inheritance;

public class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling " + getModel() + " with " + fuelCapacity + " liters.");
    }

    @Override
    public String toString() {
        return "PetrolVehicle{" + super.toString() + ", fuelCapacity=" + fuelCapacity + "}";
    }
}

// Problem 1: Transport Company Fleet Management
// Base class for all vehicles

public abstract class Vehicle {
    protected String vehicleType;
    protected double fuelTankCapacity; // in liters
    
    public Vehicle(String vehicleType, double fuelTankCapacity) {
        this.vehicleType = vehicleType;
        this.fuelTankCapacity = fuelTankCapacity;
    }
    
    // Abstract method - each vehicle calculates fuel cost differently
    public abstract double fuelCost(double km);
    
    public String getVehicleType() {
        return vehicleType;
    }
    
    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }
}

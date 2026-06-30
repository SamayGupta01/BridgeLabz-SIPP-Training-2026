// ElectricCar class - new vehicle added WITHOUT changing existing code (Open/Closed Principle)
// Calculates cost at ₹5 per km (cheaper than fuel-based vehicles)

public class ElectricCar extends Vehicle {
    private static final double FUEL_COST_PER_KM = 5.0;
    private double batteryCapacity; // in kWh
    
    public ElectricCar(double batteryCapacity) {
        super("ElectricCar", 0); // No fuel tank for electric
        this.batteryCapacity = batteryCapacity;
    }
    
    @Override
    public double fuelCost(double km) {
        return km * FUEL_COST_PER_KM;
    }
    
    public double getBatteryCapacity() {
        return batteryCapacity;
    }
}

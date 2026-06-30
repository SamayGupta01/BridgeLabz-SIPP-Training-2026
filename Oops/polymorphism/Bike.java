// Bike class - calculates fuel cost at ₹8 per km (lowest)

public class Bike extends Vehicle {
    private static final double FUEL_COST_PER_KM = 8.0;
    
    public Bike(double fuelTankCapacity) {
        super("Bike", fuelTankCapacity);
    }
    
    @Override
    public double fuelCost(double km) {
        return km * FUEL_COST_PER_KM;
    }
}

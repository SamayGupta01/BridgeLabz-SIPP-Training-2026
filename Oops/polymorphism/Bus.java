// Bus class - calculates fuel cost at ₹25 per km (higher due to size)

public class Bus extends Vehicle {
    private static final double FUEL_COST_PER_KM = 25.0;
    
    public Bus(double fuelTankCapacity) {
        super("Bus", fuelTankCapacity);
    }
    
    @Override
    public double fuelCost(double km) {
        return km * FUEL_COST_PER_KM;
    }
}

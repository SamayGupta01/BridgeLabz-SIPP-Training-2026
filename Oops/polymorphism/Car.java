// Car class - calculates fuel cost at ₹15 per km

public class Car extends Vehicle {
    private static final double FUEL_COST_PER_KM = 15.0;
    
    public Car(double fuelTankCapacity) {
        super("Car", fuelTankCapacity);
    }
    
    @Override
    public double fuelCost(double km) {
        return km * FUEL_COST_PER_KM;
    }
}

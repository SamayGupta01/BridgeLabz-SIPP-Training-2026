// Problem 1: Transport Company Fleet Management Demo
// Demonstrates polymorphism, instanceof, and open/closed principle

public class TransportFleetManagement {
    
    public static void calculateFleetCost(Vehicle[] fleet, double km) {
        System.out.println("========== Transport Fleet Fuel Cost Calculator ==========");
        System.out.println("Distance: " + km + " km\n");
        
        double totalCost = 0;
        int carCount = 0, busCount = 0, bikeCount = 0, electricCarCount = 0;
        
        for (Vehicle vehicle : fleet) {
            double cost = vehicle.fuelCost(km);
            totalCost += cost;
            
            // Using instanceof to identify vehicle type and handle accordingly
            if (vehicle instanceof Car) {
                System.out.println("[CAR] Car - Fuel Cost: Rs." + cost);
                carCount++;
            } 
            else if (vehicle instanceof Bus) {
                System.out.println("[BUS] Bus - Fuel Cost: Rs." + cost);
                busCount++;
            } 
            else if (vehicle instanceof Bike) {
                System.out.println("[BIKE] Bike - Fuel Cost: Rs." + cost);
                bikeCount++;
            } 
            else if (vehicle instanceof ElectricCar) {
                System.out.println("[ELECTRIC] ElectricCar - Charging Cost: Rs." + cost);
                electricCarCount++;
            }
        }
        
        System.out.println("\n========== Summary ==========");
        System.out.println("Total Cost for Fleet: Rs." + totalCost);
        System.out.println("Vehicles Count - Cars: " + carCount + ", Buses: " + busCount + 
                         ", Bikes: " + bikeCount + ", Electric Cars: " + electricCarCount);
    }
    
    public static void main(String[] args) {
        // Create a fleet of vehicles
        Vehicle[] fleet = {
            new Car(50),
            new Bus(200),
            new Bike(15),
            new Car(60),
            new ElectricCar(100),  // New vehicle added without changing existing code!
            new Bus(180),
            new Bike(12),
            new ElectricCar(150)
        };
        
        // Calculate fuel cost for 500 km journey
        calculateFleetCost(fleet, 500);
    }
}

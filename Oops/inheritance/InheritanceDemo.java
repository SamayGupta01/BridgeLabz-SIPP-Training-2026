package oops.inheritance;

public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== University System ===");
        GradStudent gradStudent = new GradStudent("Aman", 24, "S12345", 3.9, "AI in Healthcare");
        System.out.println(gradStudent);
        System.out.println("Is-a checks: GradStudent instanceof Student = " + (gradStudent instanceof Student));
        System.out.println("Is-a checks: GradStudent instanceof Person = " + (gradStudent instanceof Person));

        System.out.println("\n=== Library Management ===");
        Author author = new Author("Java Patterns", 2024, "Sneha Rao", "Software engineer and author.");
        author.displayInfo();

        System.out.println("\n=== Order Management ===");
        Order order = new Order("ORD001", "2026-06-24");
        ShippedOrder shippedOrder = new ShippedOrder("ORD002", "2026-06-22", "TRACK123");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD003", "2026-06-20", "TRACK789", "2026-06-23");
        System.out.println(order);
        System.out.println(shippedOrder);
        System.out.println(deliveredOrder);

        System.out.println("\n=== Vehicle Management ===");
        ElectricVehicle electricVehicle = new ElectricVehicle("Model E", 180, 75);
        PetrolVehicle petrolVehicle = new PetrolVehicle("Model P", 200, 55);
        System.out.println(electricVehicle);
        electricVehicle.charge();
        System.out.println(petrolVehicle);
        petrolVehicle.refuel();
    }
}

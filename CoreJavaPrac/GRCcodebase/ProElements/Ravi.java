package CoreJavaPrac.GRCcodebase.ProElements;

public class Ravi {
    public static void main(String[] args) {

        String name = "Ravi";
        int age = 22;
        int rank = 5;
        double salary = 50000;
        float membershipFee = 1500.50f;

        double annualBonus = salary * 0.12;
        int bonusInt = (int) annualBonus;

        System.out.println("===== WELCOME CARD =====");
        System.out.println("Name           : " + name);
        System.out.println("Age            : " + age);
        System.out.println("Rank           : " + rank);
        System.out.println("Salary         : " + salary);
        System.out.println("Membership Fee : " + membershipFee);
        System.out.println("Annual Bonus   : " + bonusInt);
        System.out.println("========================");
    }
}

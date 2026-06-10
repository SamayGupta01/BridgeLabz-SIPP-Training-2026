package CoreJavaPrac.GRCcodebase.ControlFlow;

public class KingdomTaxSystem {

    static double getTaxRate(double income) {
        if (income < 10_000)
            return 0.05;
        else if (income <= 50_000)
            return 0.15;
        else
            return 0.30;
    }

    static String getBracket(double income) {
        return (income < 10_000) ? "Low  (5%)" : (income <= 50_000) ? "Mid  (15%)" : "High (30%)";
    }

    static void printCitizenTax(int id, double income) {
        double tax = income * getTaxRate(income);
        System.out.printf("  Citizen %-2d | Income: %9.2f | Bracket: %-11s | Tax: %9.2f%n",
                id, income, getBracket(income), tax);
    }

    public static void main(String[] args) {

        System.out.println("=== SINGLE CITIZEN ===");
        printCitizenTax(1, 35_000);

        double[] incomes = {5_000, 9_999, 10_000, 25_000, 50_000,
                50_001, 80_000, 1_20_000, 3_500, 47_500};

        System.out.println("\n=== KINGDOM TAX LEDGER ===");
        System.out.println("--------------------------------------------------------------");
        double total = 0;
        for (int i = 0; i < incomes.length; i++) {
            total += incomes[i] * getTaxRate(incomes[i]);
            printCitizenTax(i + 1, incomes[i]);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.printf("  Total Tax Collected : Rs. %.2f%n", total);

        System.out.println("\n=== SWITCH: Bracket Messages ===");
        for (int cat = 1; cat <= 3; cat++) {
            switch (cat) {
                case 1: System.out.println("  Low  → Basic subsistence group."); break;
                case 2: System.out.println("  Mid  → Standard contributor.");    break;
                case 3: System.out.println("  High → Elite taxpayer.");          break;
            }
        }
    }
}
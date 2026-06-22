package GRCcodebase.Input_Output;

import java.io.*;
import java.util.*;

public class ExpenseLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("expenses.txt", true));

            System.out.print("Category: ");
            String category = sc.nextLine();

            System.out.print("Amount: ");
            int amount = sc.nextInt();

            bw.write(category + " - " + amount);
            bw.newLine();

            bw.close();

            System.out.println("Expense saved.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
package GRCcodebase.Input_Output;

import java.io.*;

public class GroceryBill {
    public static void main(String[] args) {
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("bill.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                count++;
            }

            br.close();

            System.out.println("Total Lines = " + count);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
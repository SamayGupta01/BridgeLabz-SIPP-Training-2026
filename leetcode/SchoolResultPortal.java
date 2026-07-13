import java.io.*;
import java.util.*;

public class SchoolResultPortal {

    public static void main(String[] args) {

        String inputFile = "students.txt";
        String outputFile = "reportcards.txt";

        try (
                Scanner sc = new Scanner(new File(inputFile));
                FileWriter fw = new FileWriter(outputFile, true); // true = append mode
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)
        ) {

            out.println("\n===== REPORT CARD =====");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\s+");

                String name = data[0];
                int total = 0;

                for (int i = 1; i < data.length; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double average = (double) total / (data.length - 1);

                out.printf("Name: %-10s Average Marks: %.2f%n",
                        name, average);
            }

            out.println("=======================\n");

            System.out.println("Report cards generated successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file '" + inputFile + "' not found.");
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid mark format in input file.");
        }
    }
}
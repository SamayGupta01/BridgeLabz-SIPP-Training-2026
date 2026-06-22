package GRCcodebase.Input_Output;

import java.io.*;

public class SchoolResult {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("reportcard.txt", true));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0];
                int m1 = Integer.parseInt(data[1]);
                int m2 = Integer.parseInt(data[2]);
                int m3 = Integer.parseInt(data[3]);

                double avg = (m1 + m2 + m3) / 3.0;

                bw.write("Name: " + name);
                bw.newLine();
                bw.write("Average: " + avg);
                bw.newLine();
                bw.write("------------------");
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("Report cards generated.");
        } catch (FileNotFoundException e) {
            System.out.println("Student file not found.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
package GRCcodebase.Input_Output;

import java.io.*;
import java.util.*;

public class Feedback {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BufferedWriter bw = new BufferedWriter(
                new FileWriter("feedback.txt"));

        for (int i = 1; i <= 5; i++) {
            bw.write(sc.nextLine());
            bw.newLine();
        }

        bw.close();

        BufferedReader br = new BufferedReader(
                new FileReader("feedback.txt"));

        String line;
        int count = 0;

        while ((line = br.readLine()) != null) {
            if (line.toLowerCase().contains("good")) {
                count++;
            }
        }

        br.close();

        System.out.println("Good Feedback Count = " + count);
    }
}
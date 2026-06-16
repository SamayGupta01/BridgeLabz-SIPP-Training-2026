package GRCcodebase.Recursion;

import java.util.Scanner;

public class ReverseString {
    static String reverse(String str) {
        if (str.length() == 0) {
            return "";
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(reverse(str));
    }
}
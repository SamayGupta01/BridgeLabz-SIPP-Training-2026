package GRCcodebase.String;

import java.util.*;
public class SpyAgency {

    // Reverse String
    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Palindrome Check
    static boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(reverse(str));
    }

    // Count Vowels and Consonants
    static void countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }

        System.out.println("Vowels = " + vowels);
        System.out.println("Consonants = " + consonants);
    }

    // Anagram Check
    static boolean isAnagram(String s1, String s2) {
        char[] arr1 = s1.toLowerCase().toCharArray();
        char[] arr2 = s2.toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    // First Non-Repeating Character
    static char firstNonRepeating(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (str.indexOf(ch) == str.lastIndexOf(ch))
                return ch;
        }

        return '\0';
    }

    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Secret Message: ");
        String message = sc.nextLine();

        System.out.println("Reversed Message: " + reverse(message));

        if (isPalindrome(message))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        countVowelsConsonants(message);

        System.out.print("Enter First Intercept: ");
        String s1 = sc.next();

        System.out.print("Enter Second Intercept: ");
        String s2 = sc.next();

        if (isAnagram(s1, s2))
            System.out.println("Anagram");
        else
            System.out.println("Not Anagram");

        char result = firstNonRepeating(message);

        if (result != '\0')
            System.out.println("First Non-Repeating Character: " + result);
        else
            System.out.println("No Non-Repeating Character Found");
    }
}
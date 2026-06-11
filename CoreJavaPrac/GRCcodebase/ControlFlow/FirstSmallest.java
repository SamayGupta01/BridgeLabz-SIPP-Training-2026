import java.util.Scanner;

public class FirstSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        System.out.println("Is the first number the smallest? "
                + (num1 <= num2 && num1 <= num3));
    }
}
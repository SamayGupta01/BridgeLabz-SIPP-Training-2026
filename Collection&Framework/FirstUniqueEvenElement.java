import java.util.HashMap;

public class FirstUniqueEvenElement {
    public static int firstUniqueEven(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int number : nums) {
            if (number % 2 == 0) {
                frequency.put(number, frequency.getOrDefault(number, 0) + 1);
            }
        }

        for (int number : nums) {
            if (number % 2 == 0 && frequency.get(number) == 1) {
                return number;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueEven(new int[] {1, 2, 4, 2, 6, 4}));
    }
}

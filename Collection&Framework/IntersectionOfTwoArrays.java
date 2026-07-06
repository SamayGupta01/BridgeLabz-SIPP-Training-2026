import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> firstSet = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int number : nums1) {
            firstSet.add(number);
        }

        for (int number : nums2) {
            if (firstSet.contains(number)) {
                resultSet.add(number);
            }
        }

        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int number : resultSet) {
            result[index++] = number;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = intersection(new int[] {1, 2, 2, 1}, new int[] {2, 2});
        System.out.println(Arrays.toString(result));
    }
}

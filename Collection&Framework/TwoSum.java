import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexByNumber = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int required = target - nums[i];
            if (indexByNumber.containsKey(required)) {
                return new int[] {indexByNumber.get(required), i};
            }
            indexByNumber.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }
}

import java.util.Arrays;

public class BubbleSortSwapCount {

    static int bubbleSortSwapCount(int[] nums) {
        int n = nums.length;
        int swapCount = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return swapCount;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {4, 3, 2, 1},
            {1, 2, 3}
        };
        for (int[] nums : testCases) {
            int[] original = nums.clone();
            System.out.println("Input:  " + Arrays.toString(original));
            System.out.println("Total swaps: " + bubbleSortSwapCount(nums) + "\n");
        }
    }
}

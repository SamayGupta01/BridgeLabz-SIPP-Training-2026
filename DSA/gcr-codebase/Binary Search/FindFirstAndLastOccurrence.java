import java.util.Arrays;

public class FindFirstAndLastOccurrence {

    static int[] findFirstAndLast(int[] arr, int target) {
        int first = findBound(arr, target, true);
        if (first == -1) return new int[]{-1, -1};
        int last = findBound(arr, target, false);
        return new int[]{first, last};
    }

    static int findBound(int[] arr, int target, boolean findFirst) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                if (findFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 8, 10};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("First/Last of 8: " + Arrays.toString(findFirstAndLast(arr, 8)));
        System.out.println("First/Last of 6: " + Arrays.toString(findFirstAndLast(arr, 6)));
    }
}

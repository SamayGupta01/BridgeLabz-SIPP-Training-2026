import java.util.Arrays;

public class FindPeakElement {

    static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1};
        int peakIdx1 = findPeakElement(arr1);
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Peak index: " + peakIdx1 + " (value " + arr1[peakIdx1] + ")");

        int[] arr2 = {1, 2, 1, 3, 5, 6, 4};
        int peakIdx2 = findPeakElement(arr2);
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.println("Peak index: " + peakIdx2 + " (value " + arr2[peakIdx2] + ")");
    }
}

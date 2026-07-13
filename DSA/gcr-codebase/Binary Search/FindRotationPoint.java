import java.util.Arrays;

public class FindRotationPoint {

    static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] rotated = {4, 5, 6, 7, 0, 1, 2};
        int rotationIndex = findRotationPoint(rotated);
        System.out.println("Array: " + Arrays.toString(rotated));
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + rotated[rotationIndex]);
    }
}

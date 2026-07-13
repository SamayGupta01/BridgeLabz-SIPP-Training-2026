import java.util.Arrays;

public class StarBrightnessScenario {

    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static int searchRotated(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;

            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    static int[] firstAndLastOccurrence(int[] arr, int target) {
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
                if (findFirst) high = mid - 1;
                else low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    static int findMinimum(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] sortedCatalog = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println("=== 1. Standard Binary Search ===");
        System.out.println("Catalog: " + Arrays.toString(sortedCatalog));
        System.out.println("Index of 9: " + binarySearch(sortedCatalog, 9));

        int[] rotatedCatalog = {11, 13, 15, 1, 3, 5, 7, 9};
        System.out.println("\n=== 2. Search in Rotated Catalog ===");
        System.out.println("Rotated catalog: " + Arrays.toString(rotatedCatalog));
        System.out.println("Index of 5: " + searchRotated(rotatedCatalog, 5));

        int[] withDuplicates = {2, 4, 4, 4, 4, 7, 9};
        System.out.println("\n=== 3. First and Last Occurrence ===");
        System.out.println("Catalog: " + Arrays.toString(withDuplicates));
        System.out.println("First/Last of 4: " + Arrays.toString(firstAndLastOccurrence(withDuplicates, 4)));

        System.out.println("\n=== 4. Find Minimum (Rotation Point) ===");
        System.out.println("Rotated catalog: " + Arrays.toString(rotatedCatalog));
        System.out.println("Minimum brightness: " + findMinimum(rotatedCatalog));
    }
}

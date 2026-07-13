import java.util.Random;

public class HospitalEmergencyKthPriority {

    static Random rand = new Random(42);

    static int findKthLargest(int[] priorities, int k) {
        int[] arr = priorities.clone();
        int targetIndex = arr.length - k;
        return quickSelect(arr, 0, arr.length - 1, targetIndex);
    }

    static int quickSelect(int[] arr, int low, int high, int targetIndex) {
        if (low == high) return arr[low];

        int pivotIndex = low + rand.nextInt(high - low + 1);
        pivotIndex = partition(arr, low, high, pivotIndex);

        if (pivotIndex == targetIndex) {
            return arr[pivotIndex];
        } else if (targetIndex < pivotIndex) {
            return quickSelect(arr, low, pivotIndex - 1, targetIndex);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, targetIndex);
        }
    }

    static int partition(int[] arr, int low, int high, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        int storeIndex = low;
        for (int i = low; i < high; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, high);
        return storeIndex;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] priorities = {10, 30, 15, 50, 40};
        int k = 2;
        System.out.println("Priorities: " + java.util.Arrays.toString(priorities));
        System.out.println("k = " + k);
        System.out.println("Answer (kth highest priority): " + findKthLargest(priorities, k));
    }
}

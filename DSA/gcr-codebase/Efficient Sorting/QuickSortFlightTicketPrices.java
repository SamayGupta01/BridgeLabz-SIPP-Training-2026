import java.util.Arrays;

public class QuickSortFlightTicketPrices {

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] prices = {4500, 2200, 3800, 1800, 5200};
        System.out.println("Original prices: " + Arrays.toString(prices));
        quickSort(prices, 0, prices.length - 1);
        System.out.println("Sorted prices:   " + Arrays.toString(prices));
    }
}

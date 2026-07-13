import java.util.Arrays;

public class MergeSortEmployeeSalaries {

    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] salaries = {45000, 32000, 78000, 55000, 40000, 60000};
        System.out.println("Original salaries: " + Arrays.toString(salaries));
        mergeSort(salaries, 0, salaries.length - 1);
        System.out.println("Sorted salaries:   " + Arrays.toString(salaries));
    }
}

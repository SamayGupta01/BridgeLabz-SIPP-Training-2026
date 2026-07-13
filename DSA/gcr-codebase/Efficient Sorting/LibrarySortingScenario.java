import java.util.Arrays;
import java.util.Random;

public class LibrarySortingScenario {

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

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = medianOfThreePivot(arr, low, high);
            int p = lomutoPartition(arr, low, high, pivotIndex);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int medianOfThreePivot(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] < arr[low]) swap(arr, low, mid);
        if (arr[high] < arr[low]) swap(arr, low, high);
        if (arr[high] < arr[mid]) swap(arr, mid, high);
        swap(arr, mid, high);
        return high;
    }

    static int lomutoPartition(int[] arr, int low, int high, int pivotIndex) {
        int pivot = arr[pivotIndex];
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

    static void quickSort3Way(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = arr[low + (high - low) / 2];
        int lt = low, gt = high, i = low;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
        quickSort3Way(arr, low, lt - 1);
        quickSort3Way(arr, gt + 1, high);
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int[] countingSortGenres(int[] genres, int maxCode) {
        int[] counts = new int[maxCode + 1];
        for (int g : genres) counts[g]++;

        int[] sorted = new int[genres.length];
        int idx = 0;
        for (int code = 1; code <= maxCode; code++) {
            for (int c = 0; c < counts[code]; c++) {
                sorted[idx++] = code;
            }
        }
        return sorted;
    }

    static int[] randomArray(int size, int bound, Random rand) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(bound);
        return arr;
    }

    public static void main(String[] args) {
        int[] years = {2010, 1998, 2015, 2001, 2020, 1995};
        mergeSort(years, 0, years.length - 1);
        System.out.println("Merge Sort result: " + Arrays.toString(years));

        int[] years2 = {2010, 1998, 2015, 2001, 2020, 1995};
        quickSort(years2, 0, years2.length - 1);
        System.out.println("Quick Sort result: " + Arrays.toString(years2));

        int[] genres = {5, 1, 20, 3, 3, 12, 1, 7};
        int[] sortedGenres = countingSortGenres(genres, 20);
        System.out.println("Counting Sort result (genres): " + Arrays.toString(sortedGenres));

        System.out.println("\n=== Empirical Runtime Comparison (nanoseconds) ===");
        int[] sizes = {100, 1000, 10000};
        Random rand = new Random(42);

        for (int size : sizes) {
            int[] baseArray = randomArray(size, 1_000_000, rand);

            int[] mergeArr = baseArray.clone();
            long startMerge = System.nanoTime();
            mergeSort(mergeArr, 0, mergeArr.length - 1);
            long mergeTime = System.nanoTime() - startMerge;

            int[] quickArr = baseArray.clone();
            long startQuick = System.nanoTime();
            quickSort(quickArr, 0, quickArr.length - 1);
            long quickTime = System.nanoTime() - startQuick;

            int[] genreArr = randomArray(size, 20, rand);
            for (int i = 0; i < genreArr.length; i++) genreArr[i] += 1;
            long startCount = System.nanoTime();
            countingSortGenres(genreArr, 20);
            long countTime = System.nanoTime() - startCount;

            System.out.printf("Size %-6d | Merge Sort: %-10d | Quick Sort: %-10d | Counting Sort: %-10d%n",
                    size, mergeTime, quickTime, countTime);
        }
    }
}

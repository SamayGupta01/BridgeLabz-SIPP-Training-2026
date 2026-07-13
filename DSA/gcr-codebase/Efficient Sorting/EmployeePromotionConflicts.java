import java.util.Arrays;

public class EmployeePromotionConflicts {

    static long inversions = 0;
    static long equalPairs = 0;

    static long countConflicts(int[] scores) {
        int n = scores.length;
        inversions = 0;
        equalPairs = 0;

        java.util.HashMap<Integer, Long> freq = new java.util.HashMap<>();
        for (int s : scores) freq.merge(s, 1L, Long::sum);
        for (long count : freq.values()) {
            equalPairs += count * (count - 1) / 2;
        }

        int[] copy = scores.clone();
        mergeSortCountInversions(copy, 0, n - 1);

        long totalPairs = (long) n * (n - 1) / 2;
        return totalPairs - inversions - equalPairs;
    }

    static void mergeSortCountInversions(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortCountInversions(arr, left, mid);
        mergeSortCountInversions(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                inversions += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] scores = {70, 95, 80, 100};
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Promotion conflicts: " + countConflicts(scores));
        System.out.println("(Document's example says 4, but applying the stated rule");
        System.out.println(" literally gives 5 — see the APPROACH note above.)");
    }
}

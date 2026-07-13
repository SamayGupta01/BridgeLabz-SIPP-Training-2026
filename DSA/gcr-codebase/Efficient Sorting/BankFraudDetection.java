import java.util.Arrays;

public class BankFraudDetection {

    static long suspiciousPairCount = 0;

    static long countSuspiciousPairs(int[] amounts) {
        suspiciousPairCount = 0;
        int[] copy = amounts.clone();
        mergeSortCount(copy, 0, copy.length - 1);
        return suspiciousPairCount;
    }

    static void mergeSortCount(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortCount(arr, left, mid);
        mergeSortCount(arr, mid + 1, right);

        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) arr[i] > 3L * arr[j]) {
                j++;
            }
            suspiciousPairCount += (j - (mid + 1));
        }

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
        int[] amounts = {12, 4, 5, 2};
        System.out.println("Amounts: " + Arrays.toString(amounts));
        System.out.println("Suspicious pairs: " + countSuspiciousPairs(amounts));
        System.out.println("(Document's example says 3, but the arithmetic in its own");
        System.out.println(" explanation is inconsistent — see the APPROACH note above.)");
    }
}

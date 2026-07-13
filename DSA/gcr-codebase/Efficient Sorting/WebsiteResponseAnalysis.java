import java.util.Arrays;

public class WebsiteResponseAnalysis {

    static long violations = 0;

    static long countViolations(int[] responseTimes) {
        violations = 0;
        int[] copy = responseTimes.clone();
        mergeSortCount(copy, 0, copy.length - 1);
        return violations;
    }

    static void mergeSortCount(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortCount(arr, left, mid);
        mergeSortCount(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                violations += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] responseTimes = {300, 250, 270, 100};
        System.out.println("Response times: " + Arrays.toString(responseTimes));
        System.out.println("Total violations: " + countViolations(responseTimes));
    }
}

import java.util.Arrays;

public class InsertionSortEmployeeIds {

    static int[] insertionSortIds(int[] ids) {
        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
        return ids;
    }

    public static void main(String[] args) {
        int[] employeeIds = {1042, 1005, 1090, 1001, 1077, 1020};
        System.out.println("Original employee IDs: " + Arrays.toString(employeeIds));
        System.out.println("Sorted employee IDs:   " + Arrays.toString(insertionSortIds(employeeIds)));
    }
}

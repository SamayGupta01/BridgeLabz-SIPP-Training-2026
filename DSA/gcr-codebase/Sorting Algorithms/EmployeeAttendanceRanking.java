import java.util.Arrays;

public class EmployeeAttendanceRanking {

    static int[] topKAttendance(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> {
            if (attendance[a] != attendance[b]) {
                return attendance[b] - attendance[a];
            }
            return employeeIds[a] - employeeIds[b];
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = employeeIds[idx[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int k = 3;

        int[] result = topKAttendance(employeeIds, attendance, k);
        System.out.println("Employee IDs: " + Arrays.toString(employeeIds));
        System.out.println("Attendance:   " + Arrays.toString(attendance));
        System.out.println("Top " + k + " employees by attendance: " + Arrays.toString(result));
        System.out.println("Expected:                        [103, 101, 104]");
    }
}

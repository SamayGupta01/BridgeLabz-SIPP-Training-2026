import java.util.Arrays;

public class MergeCustomerRecords {

    static int[] mergeSortedBranches(int[] branchA, int[] branchB) {
        int m = branchA.length, n = branchB.length;
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            result[k++] = (branchA[i] <= branchB[j]) ? branchA[i++] : branchB[j++];
        }
        while (i < m) result[k++] = branchA[i++];
        while (j < n) result[k++] = branchB[j++];

        return result;
    }

    public static void main(String[] args) {
        int[] branchA = {1, 4, 8};
        int[] branchB = {2, 5, 7};

        System.out.println("Branch A: " + Arrays.toString(branchA));
        System.out.println("Branch B: " + Arrays.toString(branchB));
        System.out.println("Result:   " + Arrays.toString(mergeSortedBranches(branchA, branchB)));
    }
}

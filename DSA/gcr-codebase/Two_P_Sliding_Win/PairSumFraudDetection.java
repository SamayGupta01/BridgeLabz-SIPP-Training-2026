import java.util.Arrays;

public class PairSumFraudDetection {

    static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {
            int sum = transactions[left] + transactions[right];

            if (sum == target) {
                return new int[] {transactions[left], transactions[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] transactions = {1200, 3500, 8000, 15000, 22000, 27999, 35000};
        int target = 49999;

        System.out.println("Transactions: " + Arrays.toString(transactions));
        System.out.println("Target: " + target);
        System.out.println("Pair: " + Arrays.toString(findPairSum(transactions, target)));
    }
}

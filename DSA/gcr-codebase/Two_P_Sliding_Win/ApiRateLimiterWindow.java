import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ApiRateLimiterWindow {

    static int longestSubarrayWithAtMostNDistinct(int[] keyIds, int n) {
        if (n <= 0) {
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < keyIds.length; end++) {
            freq.merge(keyIds[end], 1, Integer::sum);

            while (freq.size() > n) {
                int leftKey = keyIds[start];
                freq.put(leftKey, freq.get(leftKey) - 1);

                if (freq.get(leftKey) == 0) {
                    freq.remove(leftKey);
                }

                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] keyIds = {101, 102, 101, 103, 102, 102, 104, 103, 103};
        int n = 2;

        System.out.println("API key IDs: " + Arrays.toString(keyIds));
        System.out.println("Allowed distinct keys: " + n);
        System.out.println("Longest valid run: " + longestSubarrayWithAtMostNDistinct(keyIds, n));
    }
}

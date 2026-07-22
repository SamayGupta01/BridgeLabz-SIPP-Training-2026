import java.util.*;

class Subarray {

    public int subarraySumEqualsK(int[] nums, int k) {

        Map<Integer, Integer> prefixCount = new HashMap<>();

        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int num : nums) {

            runningSum += num;

            answer += prefixCount.getOrDefault(
                    runningSum - k,
                    0
            );

            prefixCount.put(
                    runningSum,
                    prefixCount.getOrDefault(runningSum, 0) + 1
            );
        }

        return answer;
    }
}
import java.util.Arrays;

public class FixedWindowCpuSpikeDetection {

    static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        if (cpuLoad.length == 0 || k <= 0 || k > cpuLoad.length) {
            return 0;
        }

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];

            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= cpuLoad[start];
                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] cpuLoad = {42, 55, 81, 90, 73, 60, 95, 88, 49};
        int k = 5;

        System.out.println("CPU load: " + Arrays.toString(cpuLoad));
        System.out.println("Window size: " + k);
        System.out.println("Maximum " + k + "-second load: " + maxSubarrayOfSizeK(cpuLoad, k));
    }
}

import java.util.Arrays;

public class BubbleSortProductPrices {

    static int[] bubbleSort(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (prices[j] > prices[j + 1]) {
                    int temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {450, 120, 780, 300, 250, 600},
            {850, 320, 150, 720, 400}
        };
        for (int[] prices : testCases) {
            int[] original = prices.clone();
            System.out.println("Input:  " + Arrays.toString(original));
            System.out.println("Output: " + Arrays.toString(bubbleSort(prices)) + "\n");
        }
    }
}

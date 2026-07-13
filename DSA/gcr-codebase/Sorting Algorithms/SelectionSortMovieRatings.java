import java.util.Arrays;

public class SelectionSortMovieRatings {

    static int[] selectionSort(int[] ratings) {
        int n = ratings.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (ratings[j] < ratings[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = ratings[i];
                ratings[i] = ratings[minIdx];
                ratings[minIdx] = temp;
            }
        }
        return ratings;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {8, 5, 9, 7, 6, 10},
            {7, 4, 9, 3, 8}
        };
        for (int[] ratings : testCases) {
            int[] original = ratings.clone();
            System.out.println("Input:  " + Arrays.toString(original));
            System.out.println("Output: " + Arrays.toString(selectionSort(ratings)) + "\n");
        }
    }
}

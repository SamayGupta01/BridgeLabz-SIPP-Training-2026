import java.util.Arrays;

public class SelectionSortExamScores {

    static int[] selectionSortScores(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = scores[i];
                scores[i] = scores[minIdx];
                scores[minIdx] = temp;
            }
        }
        return scores;
    }

    public static void main(String[] args) {
        int[] examScores = {72, 55, 90, 63, 48, 81, 77};
        System.out.println("Original scores: " + Arrays.toString(examScores));
        System.out.println("Sorted scores:   " + Arrays.toString(selectionSortScores(examScores)));
    }
}

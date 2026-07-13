import java.util.*;

public class SportsMeetScenario {

    static class SortResult {
        int[] sorted;
        int swapCount;
        boolean isBestCase;

        SortResult(int[] sorted, int swapCount, boolean isBestCase) {
            this.sorted = sorted;
            this.swapCount = swapCount;
            this.isBestCase = isBestCase;
        }
    }

    static SortResult bubbleSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        int swapCount = 0;
        boolean isBestCase = true;

        for (int i = 0; i < n - 1; i++) {
            boolean swappedThisPass = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapCount++;
                    swappedThisPass = true;
                    if (i == 0) isBestCase = false;
                }
            }
            if (!swappedThisPass) break;
        }
        return new SortResult(a, swapCount, isBestCase);
    }

    static SortResult insertionSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        int swapCount = 0;
        boolean isBestCase = true;

        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            boolean moved = false;
            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j--;
                swapCount++;
                moved = true;
            }
            a[j + 1] = key;
            if (moved) isBestCase = false;
        }
        return new SortResult(a, swapCount, isBestCase);
    }

    static List<Object[]> top3Medalists(List<Object[]> athletes) {
        List<Object[]> ranked = new ArrayList<>(athletes);
        ranked.sort((x, y) -> (int) y[1] - (int) x[1]);
        return ranked.subList(0, Math.min(3, ranked.size()));
    }

    static int[] traceBubbleSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        System.out.println("Initial array: " + Arrays.toString(a));
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(a));
            if (!swapped) {
                System.out.println("No swaps in this pass -> array is sorted, stopping early.");
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Random random = new Random(42);
        int numAthletes = 50;
        List<Object[]> athletes = new ArrayList<>();
        int[] scoresOnly = new int[numAthletes];
        for (int i = 0; i < numAthletes; i++) {
            int score = random.nextInt(101);
            athletes.add(new Object[]{"Athlete_" + (i + 1), score});
            scoresOnly[i] = score;
        }

        System.out.println("=== Bubble Sort on 50 athlete scores ===");
        SortResult bResult = bubbleSort(scoresOnly);
        System.out.println("Total swaps: " + bResult.swapCount);
        System.out.println("Already sorted (best case)? " + bResult.isBestCase);

        System.out.println("\n=== Insertion Sort on 50 athlete scores ===");
        SortResult iResult = insertionSort(scoresOnly);
        System.out.println("Total swaps/shifts: " + iResult.swapCount);
        System.out.println("Already sorted (best case)? " + iResult.isBestCase);

        System.out.println("\n=== Top 3 Medalists ===");
        String[] medals = {"Gold", "Silver", "Bronze"};
        List<Object[]> top3 = top3Medalists(athletes);
        for (int rank = 0; rank < top3.size(); rank++) {
            System.out.println(medals[rank] + ": " + top3.get(rank)[0] + " - " + top3.get(rank)[1]);
        }

        System.out.println("\n=== Pass-by-pass Bubble Sort trace on [64, 25, 12, 22, 11] ===");
        traceBubbleSort(new int[]{64, 25, 12, 22, 11});
    }
}

package GRCcodebase.Recursion;

public class Subsets {

    static void generateSubsets(int[] arr, int index, String subset) {
        if (index == arr.length) {
            System.out.println("[" + subset + "]");
            return;
        }

        generateSubsets(arr, index + 1, subset);

        if (subset.isEmpty())
            generateSubsets(arr, index + 1, subset + arr[index]);
        else
            generateSubsets(arr, index + 1, subset + "," + arr[index]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};

        generateSubsets(arr, 0, "");
    }
}
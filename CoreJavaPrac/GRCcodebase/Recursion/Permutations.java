package GRCcodebase.Recursion;

public class Permutations {

    static void permute(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            String remaining =
                    str.substring(0, i) + str.substring(i + 1);

            permute(remaining, ans + ch);
        }
    }

    public static void main(String[] args) {

        String str = "ABC";

        permute(str, "");
    }
}

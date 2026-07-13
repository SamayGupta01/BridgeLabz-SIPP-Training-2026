import java.util.HashMap;
import java.util.Map;

public class MinimumCoverageWindow {

    static String minWindowSubstring(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> window = new HashMap<>();
        int required = need.size();
        int formed = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            window.merge(current, 1, Integer::sum);

            if (need.containsKey(current)
                    && window.get(current).intValue() == need.get(current).intValue()) {
                formed++;
            }

            while (formed == required) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char leftChar = s.charAt(start);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                start++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String log = "INFOAERR2WARNBERR1CERR2";
        String errorCodes = "ABC";

        System.out.println("Log: " + log);
        System.out.println("Required characters: " + errorCodes);
        System.out.println("Minimum window: " + minWindowSubstring(log, errorCodes));
    }
}

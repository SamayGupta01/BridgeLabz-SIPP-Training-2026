import java.util.*;

class Solution {

    public boolean hasDuplicateToken(String[] tokens) {

        Set<String> seen = new HashSet<>();

        for (String token : tokens) {

            if (seen.contains(token)) {
                return true;
            }

            seen.add(token);
        }

        return false;
    }
}
import java.util.*;

class Sol {

    public int[] nextBusierDay(int[] visitors) {

        int n = visitors.length;

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && visitors[i] > visitors[stack.peek()]) {

                int index = stack.pop();
                answer[index] = visitors[i];
            }

            stack.push(i);
        }

        return answer;
    }
}
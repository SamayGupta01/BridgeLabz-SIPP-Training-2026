import java.util.*;

class Solution {

    public List<List<Integer>>
    broadcastByLevel(Node root) {

        List<List<Integer>> result =
                new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue =
                new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level =
                    new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node node = queue.poll();

                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}
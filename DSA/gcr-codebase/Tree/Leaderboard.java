import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

class Leaderboard {

    public List<Integer> getSortedLeaderboard(Node root) {

        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    private void inorder(Node node,
                         List<Integer> result) {

        if (node == null) {
            return;
        }

        inorder(node.left, result);

        result.add(node.val);

        inorder(node.right, result);
    }
}
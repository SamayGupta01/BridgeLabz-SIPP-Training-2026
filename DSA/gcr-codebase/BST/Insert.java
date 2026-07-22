class Solution {

    public Node insert(Node root, int value) {

        if (root == null) {
            return new Node(value);
        }

        if (value < root.val) {
            root.left = insert(root.left, value);
        }
        else if (value > root.val) {
            root.right = insert(root.right, value);
        }

        return root;
    }
}
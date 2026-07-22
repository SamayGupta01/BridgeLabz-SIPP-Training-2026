class Solution {

    public Node delete(Node root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = delete(root.left, key);
        }
        else if (key > root.val) {
            root.right = delete(root.right, key);
        }
        else {

            if (root.left == null &&
                root.right == null) {

                return null;
            }

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            Node successor = findMin(root.right);

            root.val = successor.val;

            root.right =
                delete(root.right,
                       successor.val);
        }

        return root;
    }

    private Node findMin(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
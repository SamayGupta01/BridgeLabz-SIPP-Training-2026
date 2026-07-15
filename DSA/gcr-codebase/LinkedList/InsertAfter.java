class InsertAfter {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    void insertAfter(Node current, int trackId) {
        Node newNode = new Node(trackId);
        newNode.next = current.next;
        current.next = newNode;
    }
}

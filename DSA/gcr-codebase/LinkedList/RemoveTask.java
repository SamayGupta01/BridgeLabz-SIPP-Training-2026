class RemoveTask {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node removeTask(Node head, int taskId) {
        if (head == null) return null;
        if (head.val == taskId) return head.next;

        Node prev = head, curr = head.next;
        while (curr != null && curr.val != taskId) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
        return head;
    }
}

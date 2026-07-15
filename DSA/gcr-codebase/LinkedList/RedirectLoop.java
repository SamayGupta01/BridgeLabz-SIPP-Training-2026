class RedirectLoop {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    boolean hasRedirectLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}

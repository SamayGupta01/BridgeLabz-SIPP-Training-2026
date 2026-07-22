class CallStack {

    private static class Frame {
        String functionName;
        Frame next;

        Frame(String functionName, Frame next) {
            this.functionName = functionName;
            this.next = next;
        }
    }

    private Frame top;

    public void push(String functionName) {
        top = new Frame(functionName, top);
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("No active call");
        }

        String currentFunction = top.functionName;
        top = top.next;

        return currentFunction;
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("No active call");
        }

        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
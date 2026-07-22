class UndoBuffer {
    private String[] data;
    private int top;

    public UndoBuffer(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    public boolean push(String edit) {
        if (top == data.length - 1) {
            return false; // Stack Full
        }

        data[++top] = edit;
        return true;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to undo");
        }

        return data[top--];
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
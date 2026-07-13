package oops.Generic;

import java.util.ArrayList;
import java.util.List;

class Pair<T, U> {
    private final T first;
    private final U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class GenericStack<T> {
    private final List<T> items = new ArrayList<>();

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}

class Repository<T> {
    private final List<T> entities = new ArrayList<>();

    public void save(T entity) {
        entities.add(entity);
    }

    public List<T> findAll() {
        return new ArrayList<>(entities);
    }
}

public class GenericBasicsDemo {
    public static <T extends Comparable<T>> T findMax(T[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array must contain at least one value");
        }

        T max = values[0];
        for (T value : values) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    public static void printList(List<?> values) {
        for (Object value : values) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        Pair<String, Integer> studentMarks = new Pair<>("Aman", 92);
        System.out.println("Pair: " + studentMarks);

        GenericStack<String> stack = new GenericStack<>();
        stack.push("Java");
        stack.push("Generics");
        System.out.println("Top item: " + stack.peek());
        System.out.println("Popped item: " + stack.pop());

        Integer[] scores = {78, 91, 86, 99, 84};
        System.out.println("Maximum score: " + findMax(scores));

        Repository<String> repository = new Repository<>();
        repository.save("Book");
        repository.save("Laptop");
        System.out.println("Repository data:");
        printList(repository.findAll());
    }
}

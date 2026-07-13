package oops.Generic;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private final String itemId;
    private final String name;

    WarehouseItem(String itemId, String name) {
        this.itemId = itemId;
        this.name = name;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public abstract String getStorageInstruction();

    @Override
    public String toString() {
        return itemId + " - " + name + " (" + getStorageInstruction() + ")";
    }
}

class Electronics extends WarehouseItem {
    Electronics(String itemId, String name) {
        super(itemId, name);
    }

    @Override
    public String getStorageInstruction() {
        return "Keep dry and dust-free";
    }
}

class Groceries extends WarehouseItem {
    Groceries(String itemId, String name) {
        super(itemId, name);
    }

    @Override
    public String getStorageInstruction() {
        return "Store in cool area";
    }
}

class Furniture extends WarehouseItem {
    Furniture(String itemId, String name) {
        super(itemId, name);
    }

    @Override
    public String getStorageInstruction() {
        return "Keep in large item section";
    }
}

class Storage<T extends WarehouseItem> {
    private final List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public List<T> getItems() {
        return new ArrayList<>(items);
    }
}

public class SmartWarehouseManagementSystem {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E101", "Laptop"));
        electronicsStorage.addItem(new Electronics("E102", "Camera"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("G201", "Rice Bag"));
        groceryStorage.addItem(new Groceries("G202", "Apples"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F301", "Office Chair"));

        System.out.println("Electronics:");
        displayItems(electronicsStorage.getItems());
        System.out.println("Groceries:");
        displayItems(groceryStorage.getItems());
        System.out.println("Furniture:");
        displayItems(furnitureStorage.getItems());
    }
}

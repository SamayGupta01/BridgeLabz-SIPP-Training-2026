package oops.Generic;

import java.util.ArrayList;
import java.util.List;

interface ProductCategory {
    String getCategoryName();
}

class BookCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends ProductCategory> {
    private final String name;
    private final T category;
    private double price;

    Product(String name, T category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        price = price - (price * percentage / 100);
    }

    @Override
    public String toString() {
        return name + " | " + category.getCategoryName() + " | Rs." + String.format("%.2f", price);
    }
}

public class DynamicOnlineMarketplace {
    public static <T extends Product<? extends ProductCategory>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }

    public static void main(String[] args) {
        List<Product<? extends ProductCategory>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("Java Handbook", new BookCategory(), 650);
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", new ClothingCategory(), 900);
        Product<GadgetCategory> headphones = new Product<>("Wireless Headphones", new GadgetCategory(), 2200);

        applyDiscount(book, 10);
        applyDiscount(shirt, 15);
        applyDiscount(headphones, 20);

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(headphones);

        for (Product<? extends ProductCategory> product : catalog) {
            System.out.println(product);
        }
    }
}

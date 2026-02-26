package model;

import java.util.*;

public class Order {
    private static int counter = 1;
    private int id;
    private Map<Product, Integer> items;
    private int total;

    public Order(Map<Product, Integer> items, int total) {
        this.id = counter++;
        this.items = new HashMap<>(items);
        this.total = total;
    }

    public int getId() { return id; }
    public int getTotal() { return total; }
}
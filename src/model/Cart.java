package model;

import java.util.*;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void add(Product p, int qty) {
        items.put(p, items.getOrDefault(p, 0) + qty);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public int getTotal() {
        int sum = 0;
        for (Product p : items.keySet())
            sum += p.getPrice() * items.get(p);
        return sum;
    }

    public void clear() {
        items.clear();
    }
}
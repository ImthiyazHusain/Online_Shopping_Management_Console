package model;

import java.util.*;

public class Buyer {
    private int id;
    private String name;
    private Cart cart = new Cart();
    private List<Order> orders = new ArrayList<>();

    public Buyer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public Cart getCart() { return cart; }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
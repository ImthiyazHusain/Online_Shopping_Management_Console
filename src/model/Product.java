package model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private int price;

    public Product(int id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getPrice() { return price; }

    public void reduceQuantity(int qty) {
        this.quantity -= qty;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | Stock: " + quantity + " | Price: " + price;
    }
}
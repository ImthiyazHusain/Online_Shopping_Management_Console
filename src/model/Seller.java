package model;

import java.util.*;

public class Seller {
    private int id;
    private String name;
    private List<Product> products = new ArrayList<>();

    public Seller(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Seller(int id, String name,List<Product> p) {
        this.id = id;
        this.name = name;
        if(p != null){
            for(Product prod : p){
                this.products.add(new Product(prod.getId(), prod.getName(), prod.getQuantity(), prod.getPrice()));
            }
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void addProduct(Product p) {
        if(p != null)
            products.add(new Product(p.getId(), p.getName(), p.getQuantity(), p.getPrice()));
    }

    public void addProducts(List<Product> p) {
        if(p != null){
            for(Product prod : p){
                products.add(new Product(prod.getId(), prod.getName(), prod.getQuantity(), prod.getPrice()));
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
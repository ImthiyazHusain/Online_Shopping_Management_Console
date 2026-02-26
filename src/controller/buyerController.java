package controller;

import model.*;
import view.ViewBuyer;
import java.util.Map;

public class buyerController {
    static Buyer currentBuyer = null;

    public static boolean verify() {
        currentBuyer = ViewBuyer.verify();
        return currentBuyer != null;
    }

    public static int displayOptions(){
        int option = ViewBuyer.getBuyerOption();
        switch(option){
            case 1: viewAllProductsOption(); return 1;
            case 2: addToCartOption(); return 1;
            case 3: viewCartOption(); return 1;
            case 4: placeOrderOption(); return 1;
            case 5: viewOrdersOption(); return 1;
            case 6: System.out.println("Exiting..."); return 0;
            default: System.out.println("Invalid choice."); return 1;
        }
    }

    private static void viewAllProductsOption(){
        Storage db = new Storage();
        ViewBuyer.displayAllProducts(db.getSeller());
    }

    private static void addToCartOption(){
        int sid = ViewBuyer.getSellerId();
        int pid = ViewBuyer.getProductId();
        int qty = ViewBuyer.getQuantity();
        Storage db = new Storage();
        Seller s = null;
        for(Seller se : db.getSeller()){
            if(se.getId() == sid) { s = se; break; }
        }
        if(s == null){ System.out.println("Seller not found."); return; }
        Product prod = null;
        for(Product p : s.getProducts()){
            if(p.getId() == pid){ prod = p; break; }
        }
        if(prod == null){ System.out.println("Product not found under that seller."); return; }
        if(qty <= 0 || qty > prod.getQuantity()){ System.out.println("Invalid quantity."); return; }
        currentBuyer.getCart().add(prod, qty);
        System.out.println("Added to cart: "+prod.getName()+" x"+qty);
    }

    private static void viewCartOption(){
        ViewBuyer.displayCart(currentBuyer.getCart().getItems());
    }

    private static void placeOrderOption(){
        Map<Product,Integer> items = currentBuyer.getCart().getItems();
        if(items.isEmpty()){ System.out.println("Cart is empty."); return; }
        int total = currentBuyer.getCart().getTotal();
        System.out.println("Order Total: "+total);
        int payOpt = ViewBuyer.getPaymentOption();
        Payment pay;
        if(payOpt == 1) pay = new OnlinePayment(); else pay = new OfflinePayment();
        pay.pay(total);
        // reduce stock
        for(Product p : items.keySet()){
            int q = items.get(p);
            p.reduceQuantity(q);
        }
        Order order = new Order(items, total);
        currentBuyer.addOrder(order);
        Storage db = new Storage();
        db.getOrders().add(order);
        currentBuyer.getCart().clear();
        System.out.println("Order placed. Order ID: "+order.getId());
    }

    private static void viewOrdersOption(){
        ViewBuyer.displayOrders(currentBuyer.getOrders());
    }
}

package view;

import model.Buyer;
import model.Product;
import model.Seller;
import model.Storage;

import java.util.Map;
import java.util.List;

import static util.Input.*;

public class ViewBuyer {
    public static Buyer verify() {
        System.out.print("Enter Your ID : ");
        int id = getInt();
        Storage db = new Storage();
        Buyer b = db.getBuyerById(id);
        if(b != null){
            System.out.print("Enter your Name : ");
            String name = getString();
            if(name.equals(b.getName())) return b;
            return null;
        }
        System.out.print("No buyer found. Register new buyer? (y/n) : ");
        String ans = getString();
        if(ans.equalsIgnoreCase("y")){ 
            System.out.print("Enter Name : ");
            String name = getString();
            Buyer nb = new Buyer(id, name);
            db.addBuyer(nb);
            return nb;
        }
        return null;
    }

    public static int getBuyerOption(){
        System.out.println("\nBuyer Menu:");
        System.out.println("1. View All Products");
        System.out.println("2. Add To Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Place Order");
        System.out.println("5. View Orders");
        System.out.println("6. Exit");
        System.out.print("Enter Your Choice : ");
        int opt = getInt();
        while(opt <= 0 || opt > 6){
            System.out.print("Invalid Option!!!❌\nTry Again : ");
            opt = getInt();
        }
        return opt;
    }

    public static void displayAllProducts(List<Seller> sellers){
        int flg = 0;
        for(Seller s : sellers){
            for(Product p : s.getProducts()){
                flg = 1;
                System.out.println("Seller ID:"+s.getId()+" Seller Name:"+s.getName()+" -> "+p.toString());
            }
        }
        if(flg==0) System.out.println("No products available.");
    }

    public static int getSellerId(){
        System.out.print("Enter Seller ID : ");
        return getInt();
    }

    public static int getProductId(){
        System.out.print("Enter Product ID : ");
        return getInt();
    }

    public static int getQuantity(){
        System.out.print("Enter Quantity : ");
        return getInt();
    }

    public static void displayCart(Map<Product,Integer> items){
        if(items.isEmpty()){
            System.out.println("Cart is empty.");
            return;
        }
        int sum = 0;
        for(Product p : items.keySet()){
            int q = items.get(p);
            int sub = p.getPrice()*q;
            sum += sub;
            System.out.println(p.getName()+" | Qty: "+q+" | Unit: "+p.getPrice()+" | Subtotal: "+sub);
        }
        System.out.println("Total: "+sum);
    }

    public static int getPaymentOption(){
        System.out.println("Select Payment Method:");
        System.out.println("1. Online Payment");
        System.out.println("2. Cash on Delivery");
        System.out.print("Enter choice : ");
        int opt = getInt();
        while(opt != 1 && opt != 2){
            System.out.print("Invalid Option!!!❌\nTry Again : ");
            opt = getInt();
        }
        return opt;
    }

    public static void displayOrders(List<model.Order> orders){
        if(orders.isEmpty()){
            System.out.println("No orders placed yet.");
            return;
        }
        for(model.Order o : orders){
            System.out.println("Order ID: "+o.getId()+" | Total: "+o.getTotal());
        }
    }
}

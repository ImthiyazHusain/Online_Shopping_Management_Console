package view;

import model.Product;
import model.Seller;
import model.Storage;

import java.util.ArrayList;
import java.util.List;

import static util.Input.*;

public class ViewSeller {
    public static Seller verify() {
        System.out.println("Enter Your ID : ");
        int id = getInt();
        Storage Db = new Storage();
        for(Seller s : Db.getSeller()){
            if(id == s.getId()){
                System.out.println("Enter your Name : ");
                String name = getString();
                if(name.equals(s.getName())){
                    return s;
                }
            }
        }
        return null;
    }

    public static int getSellerOption() {
        System.out.println("\nSeller Menu:");
        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Exit");
        System.out.print("Enter Your Choice : ");
        int opt = getInt();
        while(opt <= 0 || opt > 3){
            System.out.print("Invalid Option!!!❌\nTry Again : ");
            opt = getInt();
        }
        return opt;
    }

    public static void exit() {
        System.out.println("Exiting...");
    }

    public static void displayProduct(Product p) {
        System.out.println("Item Name : "+p.getName()+"|| Price : "+p.getPrice()+"|| Quantity available : "+p.getQuantity());
    }

    public static List<Product> getNewProduct() {
        List<Product> items = new ArrayList<>();
        System.out.print("Enter Number of Products you have : ");
        int n = getInt();
        if(n==0) return items;
        else{
            while(n>0) {
                System.out.print("Enter Id : ");
                int id = getInt();
                System.out.print("\nEnter Item Name : ");
                String itemName = getString();
                System.out.print("Enter Quantity : ");
                int quantity = getInt();
                System.out.print("Enter Price Per Unit : ");
                int price = getInt();
                items.add(new Product(id,itemName,quantity,price));
                n--;
            }
        }
        return items;
    }
}
//public static boolean verify(){
//    System.out.print("Enter Your Password : ");
//    String  pass = "12345678";
//    String password = getString();
//    return pass.equals(password);
//}

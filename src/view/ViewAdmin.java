package view;

import model.*;

import java.util.*;

import static util.Input.*;

public class ViewAdmin {
    public static int getOption() {
        System.out.print("\n1. Add Seller\n2. View Sellers\n3. Remove Seller\n4. Exit" + "\n\nEnter Your Choice : ");
        int opt = getInt();
        while (opt <= 0 || opt > 4) {
            System.out.print("Invalid Option!!!❌\nTry Again : ");
            opt = getInt();
        }
        return opt;
    }
    public static boolean verify(){
        System.out.print("Enter Your Password : ");
        String  pass = "12345678";
        String password = getString();
        return pass.equals(password);
    }
    public static void exit(){
        System.out.println("Exiting...");
    }
    public static int getId(){
        System.out.println("Enter ID : ");
        return getInt();
    }
    public static String  getName(){
        System.out.println("Enter Name : ");
        return getString();
    }

    public static List<Product> getItems() {
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

    public static void displaySellers(List<Seller> sellers) {
        int flg = 0;
        for(Seller s :sellers){
            flg = 1;
            System.out.println("ID : "+s.getId()+"\nName : "+s.getName());
            System.out.println("\n---Item Having---");
            for(Product p : s.getProducts()){
                System.out.println("Item Name : "+p.getName()+"|| Quantity : "+p.getQuantity()+"|| Price : "+p.getPrice());
            }
            System.out.println();
        }
        if(flg == 0){
            System.out.println("No Sellers");
        }
    }
}

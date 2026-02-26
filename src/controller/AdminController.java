package controller;
import java.net.Socket;
import java.util.*;
import model.*;
import view.ViewAdmin;

public class AdminController {
    public static boolean verify(){
        return ViewAdmin.verify();
    }

    public static int displayOptions(){
        int option = ViewAdmin.getOption();
        if(option == 1) { addSellerOption();return 1;}
        else if(option == 2 ){ viewSellersOption();return 1;}
        else if(option == 3){ removeSellerOption(); return 1;}
        else if(option == 4) {ViewAdmin.exit(); return 0;}
        else return 0;
    }

    private static void viewSellersOption() {
        Storage db = new Storage();
        ViewAdmin.displaySellers(db.getSeller());
    }

    public static void addSellerOption(){
        int id = ViewAdmin.getId();
        String name = ViewAdmin.getName();
        Storage s = new Storage();
        Seller newSeller = new Seller(id,name);
        s.addSeller(newSeller);
        List<Product> items = ViewAdmin.getItems();
        newSeller.addProducts(items);
    }
    public static void removeSellerOption(){
        int id = ViewAdmin.getId();
        Storage s = new Storage();
        boolean removed = s.removeSeller(id);
        if(removed){
            System.out.println("Seller removed successfully.");
        } else {
            System.out.println("Seller with given ID not found.");
        }
    }
}

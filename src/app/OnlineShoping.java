package app;
import controller.MainController;
import model.Product;
import model.Seller;
import model.Storage;

import java.util.*;
public class OnlineShoping {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        MainController app = new MainController();
        Storage s = new Storage();
        List<Seller> sellers = generateSellers();
        for(Seller newSeller : sellers){
            s.addSeller(newSeller);
        }
        app.start();
    }

    private static List<Seller> generateSellers() {
        List<Seller> sellers = new ArrayList<>();
        List<Product> p = new ArrayList<>();
        p.add(new Product(1,"apple",5,100));
        p.add(new Product(2,"banana",5,30));
        sellers.add(new Seller(1,"Husain",p));
        sellers.add(new Seller(2,"Barath",p));
        sellers.add(new Seller(3,"Deepak",p));
        return sellers;
    }
}


package model;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    static List<Seller> sellers = new ArrayList<>();
    static List<Buyer> buyers = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    public List<Seller> getSeller(){
        return sellers;
    }
    public void addSeller(Seller newSeller){
        sellers.add(newSeller);
    }

    public boolean removeSeller(int id){
        for (int i = 0; i < sellers.size(); i++){
            if(sellers.get(i).getId() == id){
                sellers.remove(i);
                return true;
            }
        }
        return false;
    }
    public List<Buyer> getBuyers(){
        return buyers;
    }
    public void addBuyer(Buyer b){
        buyers.add(b);
    }

    public Buyer getBuyerById(int id){
        for(Buyer b : buyers){
            if(b.getId() == id) return b;
        }
        return null;
    }
    public List<Order> getOrders(){
        return orders;
    }
}

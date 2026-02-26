package model;

public class OfflinePayment extends Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via Cash on Delivery");
    }
}
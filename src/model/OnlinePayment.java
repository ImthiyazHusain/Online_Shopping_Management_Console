package model;

public class OnlinePayment extends Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via Online Payment");
    }
}
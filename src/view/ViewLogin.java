package view;

import util.Input;

public class ViewLogin {
    public void welcome(){
        System.out.println("-------------------------------------------");
        System.out.println("\t--- Online Shopping System---");
        System.out.println("-------------------------------------------");
    }

    public void error(){
        System.out.println("❌Wrong Credentials, Try Again");
    }

    public void success(){
        System.out.println("\n---Login Successful---");
    }

    public int showLoginMenu() {
        System.out.println("Login as:");
        System.out.println("1. Admin");
        System.out.println("2. Seller");
        System.out.println("3. Buyer");
        System.out.println("4. Exit\n");
        System.out.print("Enter your Choice : ");
        return Input.getInt();
    }
}

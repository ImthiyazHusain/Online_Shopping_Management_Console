package controller;

import model.Product;
import model.Seller;
import view.*;

public class sellerController {
    static Seller currentSeller = null;
    public static boolean verify() {
        currentSeller = ViewSeller.verify();
        if(currentSeller == null){
            return false;
        }
        return true;
    }

    public static int displayOptions() {
        int option = ViewSeller.getSellerOption();

        if (option == 1) {
            addProductOption();
            return 1;
        }
        else if (option == 2) {
            viewProductsOption();
            return 1;
        }
        else if (option == 3) {
            ViewSeller.exit();
            return 0;
        }

        return 0;
    }

    private static void viewProductsOption() {
        for(Product p : currentSeller.getProducts()){
            ViewSeller.displayProduct(p);
        }
    }

    private static void addProductOption() {
        currentSeller.addProducts(ViewSeller.getNewProduct());
    }
}

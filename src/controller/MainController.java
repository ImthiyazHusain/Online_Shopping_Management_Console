package controller;

import view.ViewLogin;

public class MainController {
    public void start(){
        ViewLogin view = new ViewLogin();
        view.welcome();
        int choice = 0;
        while(choice!=4) {
            choice = view.showLoginMenu();
            switch (choice) {
                case 1:
                    while (!AdminController.verify()) {
                        view.error();
                    }
                    view.success();
                    int run = 1;
                    while (run == 1) {
                        run = AdminController.displayOptions();
                    }
                    break;
                case 2:
                    while (!sellerController.verify()) {
                        view.error();
                    }
                    view.success();
                    run = 1;
                    while (run == 1) {
                        run = sellerController.displayOptions();
                    }
                    break;
                case 3:
                    while (!buyerController.verify()) {
                        view.error();
                    }
                    view.success();
                    run = 1;
                    while (run == 1) {
                        run = buyerController.displayOptions();
                    }
                    break;
//                case 3:
//                    while (!studentController.verify()) {
//                        view.error();
//                    }
//                    view.success();
//                    studentController.greet();
//                    run = 1;
//                    while (run == 1) {
//                        run = studentController.displayOptions();
//                    }
//                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

package ro.sda.eshop.menu;

import ro.sda.eshop.service.ProductService;

import java.util.Scanner;

public class MainMenu {
    private static final int EXIT_OPTION = 0;
    Scanner scanner = new Scanner(System.in);
    ProductService service = new ProductService();
    public void displayMenu(){
        int option = -1;
        displayOptions();
        option = readOption();
        processOption(option);
        while(option != EXIT_OPTION){
            displayMenu();
        }
    }

    private void displayOptions(){
        System.out.println("1. Show all products.");
        System.out.println("2. Select product to view (by ID).");
        System.out.println("0. Exit");
    }

    private int readOption(){
        System.out.println("Input option: ");
        return scanner.nextInt();
    }

    private void processOption(int option){
        switch (option){
            case 1:
                service.showProductList();
                return;
            case 2:
                service.showDetailedProduct(service.getIdForProduct());
                return;
            case 0:
            default:
                return;
        }
    }


}

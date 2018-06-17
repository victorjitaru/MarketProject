package ro.sda.eshop.view;

import ro.sda.eshop.service.ProductService;

import java.util.Scanner;

public class ProductsView implements MarketViewInterface {
    private static final int EXIT_OPTION = 0;
    static ProductService productService = new ProductService();

    public static void displayView() {
        int option = -1;
        System.out.println("1. List products");
        System.out.println("2. Add Product");
        System.out.println("0. Exit");
        option = readOption();
        processOption(option);
        while(option != EXIT_OPTION){
            displayView();
        }
    }

    public static int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Option: ");
        return scanner.nextInt();
    }

    public static void processOption(int option) {
        switch (option){
            case 1:
                productService.listProducts();
                return;
            case 2:
                productService.addProduct();
                return;
            case 0:
            default:
                return;
        }
    }

}

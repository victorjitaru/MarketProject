package ro.sda.eshop.view;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.impl.ProductHolder;
import ro.sda.eshop.service.ProductService;

import java.util.Scanner;

public class ProductsView implements MarketViewInterface {
    private static final int EXIT_OPTION = 0;
    Scanner scanner = new Scanner(System.in);
    ProductService service = new ProductService();
    @Override
    public void processOption(int option) {
        switch (option){
            case 1:

                return;
            case 2:
                ProductHolder productHolder = new ProductHolder();
//                productHolder.addProduct();
                return;
            case 0:
            default:
                return;
        }
    }
    @Override
    public void displayView() {
        int option = -1;
        System.out.println("1. Show all products.");
        System.out.println("2. Select product to view (by ID).");
        System.out.println("0. Exit");
        displayView();

        processOption(option);
        while(option != EXIT_OPTION){
            displayView();
        }
    }
    @Override
    public int readOption() {
        System.out.println("Input option: ");
        return scanner.nextInt();

    }
}

package ro.sda.eshop.view;

import ro.sda.eshop.service.ProductService;
import ro.sda.eshop.view.reader.ProductReader;
import ro.sda.eshop.view.reader.impl.ProductReaderImpl;

import java.util.Scanner;

public class ProductView implements MarketViewInterface {
    ProductService productService = new ProductService();
    ProductReader productReader = new ProductReaderImpl();
    int option;

    public void displayView() {
        option = -1;
        System.out.println("1. List products");
        System.out.println("2. Add Product");
        System.out.println("0. Exit");
        option = readOption();
        processOption(option);
        while (option != EXIT_OPTION) {
            displayView();
        }
    }

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Option: ");
        return scanner.nextInt();
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                productService.listProducts();
                return;
            case 2:
                productService.addProduct(productReader.readProduct());
                return;
            case 0:
            default:
                return;
        }
    }
}
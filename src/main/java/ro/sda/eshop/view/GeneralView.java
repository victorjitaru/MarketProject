package ro.sda.eshop.view;

import ro.sda.eshop.Constants;

import java.util.Scanner;

public class GeneralView implements MarketViewInterface {

    ProductView productView = new ProductView();
    StockView stockView = new StockView();
    OrderView orderView = new OrderView();

    public void displayView() {
        int option = -1;
        System.out.println("1. Select Products.");
        System.out.println("2. Select Stock.");
        System.out.println("3. Select Order.");
        System.out.println("0. Exit");
        option = readOption();
        processOption(option);
        while(option != Constants.EXIT_OPTION) {
            System.out.println("Option was " + option);
            displayView();
        }
        System.out.println("We are exiting. Option is " + option);
    }

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input option: ");
        return scanner.nextInt();
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                productView.displayView();
                return;
            case 2:
                stockView.displayView();
                return;
            case 3:
                orderView.displayView();
                return;
            case 0:
            default:
                return;
        }
    }
}

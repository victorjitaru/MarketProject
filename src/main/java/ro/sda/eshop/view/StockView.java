package ro.sda.eshop.view;

import ro.sda.eshop.Constants;
import ro.sda.eshop.service.OrderService;

import java.util.Scanner;

public class StockView implements MarketViewInterface {

    OrderService orderService = new OrderService();

    @Override
    public void displayView() {
        int option = -1;
        System.out.println("1. List Stocks.");
        System.out.println("2. Add stock.");
        System.out.println("0. Exit");
        option = readOption();
        processOption(option);
        while(option != Constants.EXIT_OPTION){
            displayView();
        }
    }

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input option: ");
        return scanner.nextInt();
    }

    public void processOption(int option) {
        switch (option){
            case 1:

                return;
            case 2:
                return;
            case 0:
            default:
                return;
        }
    }
}

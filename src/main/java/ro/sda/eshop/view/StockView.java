package ro.sda.eshop.view;

import ro.sda.eshop.repository.impl.StockHolder;
import java.util.Scanner;

public class StockView implements MarketViewInterface {
    private static final int EXIT_OPTION = 0;

    public static void displayView() {
        int option = -1;
        System.out.println("1. List Stock.");
        System.out.println("2. Add stock.");
        System.out.println("0. Exit");
        option = readOption();
        processOption(option);
        while(option != EXIT_OPTION){
            displayView();
        }
    }

    public static int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input option: ");
        return scanner.nextInt();
    }

    public static void processOption(int option) {
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

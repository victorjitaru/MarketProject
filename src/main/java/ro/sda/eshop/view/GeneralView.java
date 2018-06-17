package ro.sda.eshop.view;

import java.util.Scanner;

public class GeneralView implements MarketViewInterface {
    private static final int EXIT_OPTION = 0;

    public static void displayView() {
        int option = -1;
        System.out.println("1. Select Products.");
        System.out.println("2. Select Stock.");
        System.out.println("3. Select Order.");
        System.out.println("0. Exit");
        option = readOption();
        processOption(option);
        while(option != EXIT_OPTION) {
            displayView();
        }
    }

    public static int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input option: ");
        return scanner.nextInt();
    }

    public static void processOption(int option) {
        switch (option) {
            case 1:
                ProductsView.displayView();
                return;
            case 2:
                StockView.displayView();
                return;
            case 3:
                OrderView.displayView();
                return;
            case 0:
            default:
                return;
        }
    }
}

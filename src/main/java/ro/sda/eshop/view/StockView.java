package ro.sda.eshop.view;

import ro.sda.eshop.repository.impl.StockHolder;
import java.util.Scanner;

public class StockView implements MarketViewInterface {
    private static final int EXIT_OPTION = 0;
    @Override
    public void displayView() {
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

    @Override
    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input option: ");
        return scanner.nextInt();
    }

    @Override
    public void processOption(int option) {
        switch (option){
            case 1:

                return;
            case 2:
                StockHolder stockHolder = new StockHolder();
               // stockHolder.addStock();
                return;
            case 0:
            default:
                return;
        }
    }
}

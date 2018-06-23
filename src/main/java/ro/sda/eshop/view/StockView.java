package ro.sda.eshop.view;

import ro.sda.eshop.model.Order;
import ro.sda.eshop.model.Stock;
import ro.sda.eshop.reader.OrderReader;
import ro.sda.eshop.reader.StockReader;
import ro.sda.eshop.reader.impl.OrderReaderImpl;
import ro.sda.eshop.reader.impl.StockReaderImpl;
import ro.sda.eshop.repository.impl.StockHolder;
import ro.sda.eshop.service.OrderService;
import ro.sda.eshop.service.StockService;

import java.util.Scanner;

public class StockView implements MarketViewInterface {
    private static final int EXIT_OPTION = 0;

    OrderService orderService = new OrderService();
    StockService addStock = new StockService();

    @Override
    public void displayView() {
        int option = -1;
        System.out.println("1. List Stocks.");
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

                return;
            case 0:
            default:
                return;
        }
    }
}

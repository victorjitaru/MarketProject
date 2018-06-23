package ro.sda.eshop.view;

import ro.sda.eshop.model.Stock;
import ro.sda.eshop.service.StockService;
import ro.sda.eshop.view.displayer.StockDisplayer;
import ro.sda.eshop.view.reader.StockReader;
import ro.sda.eshop.view.reader.impl.StockReaderImpl;

import java.util.List;
import java.util.Scanner;

public class StockView implements MarketViewInterface {

    //OrderService orderService = new OrderService();

    StockService stockService = new StockService();
    StockReader stockReader = new StockReaderImpl();
    StockDisplayer stockDisplayer = new StockDisplayer();
    int option;

    @Override
    public void displayView() {
        option = -1;
        System.out.println("1. List Stocks.");
        System.out.println("2. Add stock.");
        System.out.println("0. Exit");
        option = readOption();
        processOption(option);
        while(option != EXIT_OPTION){
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
                //stockDisplayer.listStocks(stockService.listStock());
                List<Stock> stocks = stockService.listStock();
                stockDisplayer.listStocks(stocks);

                return;
            case 2:
                Stock stock = stockReader.readStock();
                stockService.addStock(stock);
                return;
            case 0:
            default:
                return;
        }
    }
}

package ro.sda.eshop.reader.impl;

import ro.sda.eshop.model.Stock;
import ro.sda.eshop.reader.StockReader;

import java.util.Scanner;

public class StockReaderImpl implements StockReader {

    public Stock readStock(){
        Stock stock = new Stock();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Product ID: ");
        stock.setProductId(scanner.nextLong());
        System.out.println();

        stock.setAmount(scanner.nextInt());
        System.out.println("Amount is: ");
        return stock;
    }

}

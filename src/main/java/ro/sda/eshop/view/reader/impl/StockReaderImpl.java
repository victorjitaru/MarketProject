package ro.sda.eshop.view.reader.impl;


import ro.sda.eshop.model.Stock;
import ro.sda.eshop.view.reader.StockReader;

import java.util.Scanner;

public class StockReaderImpl implements StockReader {

    public Stock readStock(){
        Stock stock = new Stock();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Product ID: ");
        Integer readValue = scanner.nextInt();
        stock.setId(readValue.longValue());
        System.out.println();

        System.out.println("Amount is: ");
        stock.setAmount(scanner.nextInt());
        return stock;
    }

    //reads products from a file
//    public Stock addStocksFromFile() {
//        String sourceFilePath = "src/source.txt";
//        Stock stock = new Stock();
//        try {
//            FileReader fileReader = new FileReader(sourceFilePath);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
////
//        }
//    }

}

package ro.sda.eshop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.eshop.model.Stock;
import ro.sda.eshop.repository.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StockRepositoryImpl implements Repository<Stock> {
    public static final String FILE_PATH = "stocks.json";
    StockHolder stockHolder = new StockHolder();

    public StockRepositoryImpl() {
       stockHolder.setAllStocks(readFromFile());
    }

    public Stock find(Long stockId) {
        return stockHolder.getStock(stockId);
    }

    public List<Stock> findAll() {
        return stockHolder.getAllStocks();
    }

    public void save(Stock stock) {
        stock.setId(stockHolder.getMaxId() + 1);
        stockHolder.addStock(stock);
        serialize(stockHolder.getAllStocks());
    }

    private void serialize(List<Stock> stocks) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String stocksLiteral = gson.toJson(stocks);
        writeToFile(stocksLiteral);
    }

    private void writeToFile(String stocks) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            fileWriter.write(stocks);
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private List<Stock> readFromFile() {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                sb.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.getMessage();
        }
        String stocksLiteral = sb.toString();
        Gson gson = new Gson();

        Stock[] myStocks;
        myStocks = gson.fromJson(stocksLiteral, Stock[].class);

        return Arrays.asList(myStocks);
    }

    public void saveAll(List<Stock> stocks){
        serialize(stocks);
    }


    public void delete(Long stockId) {
        stockHolder.deleteStock(stockId);
    }

    public void modifyStock(Long productId){
        int newStock = stockHolder.getStockForProdId(productId) - 1;
        Stock stock = stockHolder.setStockForProduct(productId, newStock);
        save(stock);
    }

}


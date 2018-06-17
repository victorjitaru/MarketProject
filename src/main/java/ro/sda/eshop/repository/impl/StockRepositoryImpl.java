package ro.sda.eshop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.eshop.model.Stock;
import ro.sda.eshop.repository.StockRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.getProperty;

public class StockRepositoryImpl implements StockRepository {
    public static final String FILE_PATH = "stocks.json";
    StockHolder stockHolder = new StockHolder();

    public StockRepositoryImpl() {
        this.stockHolder.setStocks(readFromFile());
    }

    public List<Stock> getAllStocks() {
        return stockHolder.getAllStocks();
    }

    public Stock getStockById(long stockId) {
        return stockHolder.getStock(stockId);
    }

    public void persistStock(Stock stock) {
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

        List<Stock> myStocks = new ArrayList<>();
        myStocks = gson.fromJson(stocksLiteral, myStocks.getClass());
        return myStocks;
    }

    public void persistStocks(List<Stock> stocks){
        serialize(stocks);
    }
}


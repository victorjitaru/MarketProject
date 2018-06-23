package ro.sda.eshop.repository;

import ro.sda.eshop.model.Stock;

import java.util.List;

public interface StockRepository {

    List<Stock> getAllStocks();
    Stock getStockById(long id);
    void persistStock(Stock stock);
    void persistStocks(List<Stock> stocks);

}

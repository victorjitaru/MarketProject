package ro.sda.eshop.service;

import ro.sda.eshop.model.Stock;
import ro.sda.eshop.repository.impl.StockRepositoryImpl;

import java.util.List;

public class StockService {

    StockRepositoryImpl stockRepositoryImpl = new StockRepositoryImpl();
    List<Stock> stocks = stockRepositoryImpl.findAll();

    public Integer getStockForProductId(Long productId) {
        for (Stock stock:stocks){
            if (stock.getProductId() == productId) {
                return stock.getAmount();
            }
        }
        return 0;
    }

    public boolean stockExists(Long productId) {
        for (Stock stock:stocks) {
            if (stock.getProductId() == productId){
                if (stock.getAmount() > 0){
                    return true;
                }
            }
        }
        return false;
    }

    public List<Stock> listStock(){
        return stockRepositoryImpl.findAll();
    }

    public void addStock(Stock stock) {
        stockRepositoryImpl.save(stock);
    }

}

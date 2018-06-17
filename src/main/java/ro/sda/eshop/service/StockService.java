package ro.sda.eshop.service;

import ro.sda.eshop.model.Stock;
import ro.sda.eshop.repository.StockRepository;
import ro.sda.eshop.repository.impl.StockRepositoryImpl;

import java.util.List;

public class StockService {

    StockRepository stockRepository = new StockRepositoryImpl();

    public int getStockForProductId(Long productId) {
        List<Stock> stocks = stockRepository.getAllStocks();

        for (Stock stock:stocks){
            if (stock.getProductId() == productId) {
                return stock.getAmount();
            }
        }
        return 0;
    }


    public boolean stockExists(Long productId) {

        List<Stock> stocks = stockRepository.getAllStocks();

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
        return stockRepository.getAllStocks();
    }
}

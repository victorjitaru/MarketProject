package ro.sda.eshop.repository.impl;

import ro.sda.eshop.model.Stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockHolder {

    private Map<Long, Stock> stocks = new HashMap<Long, Stock>();
    //add a stocks into the HashMap
    public void addStock(Stock stock) {
        this.stocks.put(stock.getId(), stock);
    }

    //puts all stocks into the HashMap
    public Stock getStock(long stockId) {
        return this.stocks.get(stockId);
    }

    // gets all stocks from HasMap
    public List<Stock> getAllStocks() {
        return new ArrayList<Stock>(this.stocks.values());
    }

    public void setAllStocks(List<Stock> stocks) {
        this.stocks.clear();
        for (Stock stock : stocks) {
            this.stocks.put(stock.getId(), stock);
        }
    }

    protected Long getMaxId() {

        Long maxId = -1L;
        for (Long key : stocks.keySet()) {
            if (key > maxId) {
                maxId = key;
            }
        }
        return maxId;
    }
    //checks if the newly added stocks already exists
    private boolean stockDuplicate(Stock stock) {
        for (Stock stock1 : stocks.values()) {
            if (stock1.equals(stock)) {
                return true;
            }
        }
        return false;
    }
    public void deleteStock(Long id) {
        this.stocks.remove(id);
    }

    public int getStockForProdId(Long productId){
        for(Stock stock:stocks.values()){
            if(stock.getProductId() == productId){
                return stock.getAmount();
            }
        }
         return 0;
    }

    public Stock setStockForProduct(Long productId, int amount){
        for(Stock stock:stocks.values()){
            if(stock.getProductId() == productId){
                stock.setAmount(amount);
                return stock;
            }
        }
        return null;
    }
}

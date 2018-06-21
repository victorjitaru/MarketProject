package ro.sda.eshop.repository.impl;

import ro.sda.eshop.model.Stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* TODO: put getters and setters for same field one after the other
* */
public class StockHolder {

    private Map<Long, Stock> stocks = new HashMap<Long, Stock>();

    protected Long getMaxId() {
        Long maxId = -1L;
        for (Long key : stocks.keySet()) {
            if (key > maxId) {
                maxId = key;
            }
        }
        return maxId;
    }

    //add a stocks into the HashMap
    public void addStock(Stock stock) {
        this.stocks.put(stock.getId(), stock);
    }

    //puts all stocks into the HashMap
    /*
    * TODO: rename to setAllStocks
    * */
    public void setStocks(List<Stock> stocks) {
        this.stocks.clear();
        for (Stock stock : stocks) {
            this.stocks.put(stock.getId(), stock);
        }
    }

    // gets a stocks from tha HasMap
    public Stock getStock(long id) {
        return this.stocks.get(id);
    }

    // gets all stocks from HasMap
    public List<Stock> getAllStocks() {
        return new ArrayList<Stock>(this.stocks.values());
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

}

package ro.sda.eshop.view.displayer;

import ro.sda.eshop.model.Stock;

import java.util.List;

public class StockDisplayer {

    /*
    *
    * */
    public void listStocks(List<Stock> stocks) {
        for(Stock stock: stocks){
            System.out.println(stock);
        }
    }



}

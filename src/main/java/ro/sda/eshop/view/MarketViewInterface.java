package ro.sda.eshop.view;

import ro.sda.eshop.exception.MissingProductFromStockException;

public interface MarketViewInterface {

    void displayView() throws MissingProductFromStockException;
    int readOption();
    void processOption(int option) throws MissingProductFromStockException;
    int EXIT_OPTION = 0;

}

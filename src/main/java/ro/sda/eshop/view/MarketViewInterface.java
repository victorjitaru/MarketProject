package ro.sda.eshop.view;

public interface MarketViewInterface {

    void displayView();
    int readOption();
    void processOption(int option);
    int EXIT_OPTION = 0;

}

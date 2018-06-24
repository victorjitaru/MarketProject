package ro.sda.eshop.exception;

public class MissingProductFromStockException extends Exception {
    public MissingProductFromStockException(String message){
        super(message);
    }
}

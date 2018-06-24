package ro.sda.eshop.exception;

public class MissingProductFromOrderException extends Exception {
    public MissingProductFromOrderException(String message){
        super(message);
    }
}

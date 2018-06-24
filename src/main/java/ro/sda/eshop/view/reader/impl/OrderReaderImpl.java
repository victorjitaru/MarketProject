package ro.sda.eshop.view.reader.impl;

import ro.sda.eshop.model.Order;
import ro.sda.eshop.view.reader.OrderReader;

import java.util.Scanner;

public class OrderReaderImpl implements OrderReader {
    ProductReaderImpl productReader = new ProductReaderImpl();


    /*
     * Citest produsele dintr-un "order"
     * */
    public Order readOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        System.out.println("Input product id: ");
        String idValue = scanner.nextLine();
        while (!idValue.equals("x")) {
            order.getProductIds().add(Long.valueOf(idValue));
            idValue = productReader.readProductId();
        }
        return order;
    }
}

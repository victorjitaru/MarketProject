package ro.sda.eshop.reader.impl;

import ro.sda.eshop.model.Order;
import ro.sda.eshop.reader.OrderReader;

import java.util.Scanner;

public class OrderReaderImpl implements OrderReader {


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
            System.out.println("Input product id: ");
            idValue = scanner.nextLine();
        }
        return order;
    }
}

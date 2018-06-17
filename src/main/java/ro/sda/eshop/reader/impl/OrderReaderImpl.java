package ro.sda.eshop.reader.impl;

import ro.sda.eshop.model.Order;
import ro.sda.eshop.reader.OrderReader;

import java.util.Scanner;

public class OrderReaderImpl implements OrderReader {

    /*
    * Citest produsele dintr-un "order"
    * */
    public Order readOrder() {
        Order order = new Order();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ID: ");
        Integer readValue = scanner.nextInt();
        order.setId(readValue.longValue());
        return order;
    }
}

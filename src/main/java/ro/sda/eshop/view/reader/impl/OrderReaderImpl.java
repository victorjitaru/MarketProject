package ro.sda.eshop.view.reader.impl;

import ro.sda.eshop.exception.MissingProductFromStockException;
import ro.sda.eshop.model.Order;
import ro.sda.eshop.model.OrderStatus;
import ro.sda.eshop.repository.impl.StockRepositoryImpl;
import ro.sda.eshop.view.reader.OrderReader;

import java.util.Scanner;

public class OrderReaderImpl implements OrderReader {
    ProductReaderImpl productReader = new ProductReaderImpl();
    StockRepositoryImpl stockRepository = new StockRepositoryImpl();

    /*
     * Citest produsele dintr-un "order"
     * */
    public Order readOrder() {
        String idValue = null;

        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        order.setStatus(OrderStatus.Pending);
        System.out.println("Input product id: ");
        idValue = scanner.nextLine();
        while (!idValue.equals("x")) {
            Long value = Long.valueOf(idValue);
            order.getProductIds().add(value);

            stockRepository.modifyStock(value);
            idValue = productReader.readProductId();
        }
        return order;
    }
}

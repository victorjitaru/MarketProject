package ro.sda.eshop.view;


import ro.sda.eshop.exception.MissingProductFromOrderException;
import ro.sda.eshop.exception.MissingProductFromStockException;
import ro.sda.eshop.exception.OrderStatusException;
import ro.sda.eshop.model.Order;
import ro.sda.eshop.service.OrderService;
import ro.sda.eshop.service.ProductService;
import ro.sda.eshop.view.reader.OrderReader;
import ro.sda.eshop.view.reader.impl.OrderReaderImpl;

import java.util.Scanner;

public class OrderView implements MarketViewInterface {
    OrderService orderService = new OrderService();
    OrderReader orderReader = new OrderReaderImpl();
    int option;

    public void displayView() {
        option = -1;
        System.out.println("1. List Orders.");
        System.out.println("2. Place order.");
        System.out.println("3. Cancel order.");
        System.out.println("4. Delete product from order.");
        System.out.println("0. Exit");
        option = readOption();
        processOption(option);
        while (option != EXIT_OPTION) {
            displayView();
        }
    }

    public int readOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input option: ");
        return scanner.nextInt();
    }

    public void processOption(int option) {
        Order order = null;
        switch (option) {
            case 1:
                orderService.listOrders();
                return;
            case 2:
                order = orderReader.readOrder();
                orderService.placeOrder(order);
                return;
            case 3:
                orderService.deleteAllProductsFromOrder(order);
                return;
            case 4:
                try {
                    orderService.deleteProductFromOrder(order);
                }catch (MissingProductFromOrderException e){
                    e.getMessage();
            } catch (OrderStatusException e){
                    e.getMessage();
                }
                return;
            case 0:
            default:
                return;
        }
    }
}




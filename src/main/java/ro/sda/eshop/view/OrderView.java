package ro.sda.eshop.view;


import ro.sda.eshop.model.Order;
import ro.sda.eshop.reader.OrderReader;
import ro.sda.eshop.reader.impl.OrderReaderImpl;
import ro.sda.eshop.service.OrderService;

import java.util.Scanner;

public class OrderView implements MarketViewInterface {
    private static final int EXIT_OPTION = 0;
    static OrderService orderService = new OrderService();

    /*
    * TODO:
    * declare an order reader and use it here
    * */

    public void displayView() {
        int option = -1;
        System.out.println("1. List Orders.");
        System.out.println("2. Place order.");
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
        switch (option){
            case 1:
                orderService.listOrders();
                return;
            case 2:
                /*
                * TODO: use order reader from class
                * */
                OrderReader orderReader = new OrderReaderImpl();
                Order order = orderReader.readOrder();
                orderService.placeOrder(order);
                return;
            case 0:
            default:
                return;
        }
    }


}

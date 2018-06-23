package ro.sda.eshop.view;


import ro.sda.eshop.Constants;
import ro.sda.eshop.model.Order;
import ro.sda.eshop.view.reader.OrderReader;
import ro.sda.eshop.view.reader.impl.OrderReaderImpl;
import ro.sda.eshop.service.OrderService;

import java.util.Scanner;

public class OrderView implements MarketViewInterface {
    static OrderService orderService = new OrderService();

    /*
    * TODO: - DONE
    * declare an order reader and use it here
    * */
    OrderReader orderReader = new OrderReaderImpl();

    public void displayView() {
        int option = -1;
        System.out.println("1. List Orders.");
        System.out.println("2. Place order.");
        System.out.println("0. Exit");
        option = readOption();
        processOption(option);
        while (option != Constants.EXIT_OPTION) {
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
                * TODO: use order reader from class - DONE
                * */
                Order order = orderReader.readOrder();
                orderService.placeOrder(order);
                return;
            case 0:
            default:
                return;
        }
    }


}

package ro.sda.eshop.view.displayer;

import ro.sda.eshop.model.Order;

import java.util.List;

public class OrderDisplayer {

    public void listOrders(List<Order> orders){

        for(Order order:orders){

            System.out.println(order.toString());
        }
    }

}

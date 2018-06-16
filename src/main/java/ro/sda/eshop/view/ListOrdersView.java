package ro.sda.eshop.view;

import ro.sda.eshop.model.Order;

import java.util.List;

public class ListOrdersView {
    public void displayListOfProducts(List<Order> orders){
        for(Order order:orders){
            displayMinimumInfoOrder(order);
        }
    }

    private void displayMinimumInfoOrder(Order order){
        System.out.println(order.getId() + "(" + order.getStatus() + ") \n");
    }
}

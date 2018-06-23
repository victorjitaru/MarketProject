package ro.sda.eshop.service;

import ro.sda.eshop.model.Order;
import ro.sda.eshop.model.OrderStatus;
import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.impl.OrderHolder;
import ro.sda.eshop.repository.impl.OrderRepositoryImpl;

import java.util.List;

public class OrderService {

    OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
    ProductService productService = new ProductService();

    /*
    * TODO: When an Order is not valid throw a custom exception for each case
    * e.g. InexistentProductException, InsufficientStockException
    * */
    private boolean validOrder(Order order){
        return true;
    }


    /*
    * places an order
    * */
    public void placeOrder(Order order){
        order.setStatus(OrderStatus.Placed);
        orderRepository.persistOrder(order);
    }
/*
TODO: Order displayer for listOrder/listOrders
 */
    public void listOrders(){
        List<Order> orders = orderRepository.getAll();
        for(Order order:orders){
            order.toString();
            System.out.println();
        }
    }

    public void deliverOrder(Order order){
        order.setStatus(OrderStatus.Delivered);
    }

    public void returnOrder(Order order){
        order.setStatus(OrderStatus.Returned);
    }

    /*
    * TODO: Validate status of order before you can delete product id - DONE
    * e.g. Order cannot be in other state than Placed
    * if no more products in Order after delete, delete Order
    * */
    public void deleteProductFromOrder(Product product, Order order) {
        if(order.getStatus().equals(OrderStatus.Placed)) {
            order.getProductIds().remove(product.getId());
            if(order.getProductIds() == null){
                deleteOrder(order);
            }
        } else {
            System.out.println("Error");
            /*
            *TODO: insert custom exception
             */
        }

    }

    private void deleteOrder(Order order){
        orderRepository.deleteOrder(order);
    }

    public void deleteAllProductsFromOrder(Order order) {
        order.getProductIds().clear();
    }

}

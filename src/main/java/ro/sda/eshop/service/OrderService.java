package ro.sda.eshop.service;

import ro.sda.eshop.model.Order;
import ro.sda.eshop.model.OrderStatus;
import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.impl.OrderRepositoryImpl;

public class OrderService {

    OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
    ProductService productService = new ProductService();

    public Order createOrder(){
        Order newOrder = new Order();
        newOrder.setStatus(OrderStatus.Pending);
        orderRepository.persistOrder(newOrder);
        return newOrder;
    }

    private boolean validOrder(Order order){


        return true;
    }

    public void addProdToOrder(Product product, Order order) {
        order.getProductIds().add(product.getId());
    }

    public void placeOrder(Order order){
        order.setStatus(OrderStatus.Placed);
        orderRepository.persistOrder(order);
    }

    public void deliverOrder(Order order){
        order.setStatus(OrderStatus.Delivered);
    }

    public void returnOrder(Order order){
        order.setStatus(OrderStatus.Returned);
    }

    public void deleteProductFromOrder(Product product, Order order) {
        order.getProductIds().remove(product.getId());
    }

    public void deleteAllProductsFromOrder(Order order) {
        order.getProductIds().clear();
    }

}

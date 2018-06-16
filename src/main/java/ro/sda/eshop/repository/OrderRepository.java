package ro.sda.eshop.repository;

import ro.sda.eshop.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAll();
    Order getOrderById(long id);
    void persistOrder(Order order);
    void persistAllOrders(List<Order> orders);
}

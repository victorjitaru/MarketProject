package ro.sda.eshop.repository;

import ro.sda.eshop.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    Order find(long id);
    void save(Order order);
    void saveAll(List<Order> orders);
}

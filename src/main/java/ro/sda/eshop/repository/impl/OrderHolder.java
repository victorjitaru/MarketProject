package ro.sda.eshop.repository.impl;

import ro.sda.eshop.model.Order;
import ro.sda.eshop.model.OrderStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHolder {

    private Map<Long, Order> orders = new HashMap<Long, Order>();

    //Used to generate unique Id
    public Long getMaxId() {
        Long maxId = -1L;
        for (Long key : orders.keySet()) {
            if (key > maxId) {
                maxId = key;
            }
        }
        return maxId;
    }

    public void addOrder(Order order) {
        order.setStatus(OrderStatus.Pending);
        this.orders.put(order.getId(), order);
    }

    public void setOrder(List<Order> orders){
        this.orders.clear();
        for(Order order:orders){
            this.orders.put(order.getId(), order);
        }
    }

    public List<Order> getAllOrders() {
        return new ArrayList<Order>(this.orders.values());
    }

    public Order getOrder(long id) {
        return this.orders.get(orders.get(id));
    }

}

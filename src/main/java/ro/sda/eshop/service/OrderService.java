package ro.sda.eshop.service;

import ro.sda.eshop.exception.OrderStatusException;
import ro.sda.eshop.model.Order;
import ro.sda.eshop.model.OrderStatus;
import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.impl.OrderRepositoryImpl;
import ro.sda.eshop.view.displayer.OrderDisplayer;

public class OrderService {

    OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
    ProductService productService = new ProductService();
    OrderDisplayer orderDisplayer =  new OrderDisplayer();

    /*
    * TODO: When an Order is not valid throw a custom exception for each case
    * e.g. InexistentProductException, InsufficientStockException
    * */
    private boolean validOrder(Order order){
        return true;
    }

    public void listOrders(){
        orderDisplayer.listOrders(orderRepository.findAll());
    }

    public void placeOrder(Order order){
        order.setStatus(OrderStatus.Placed);
        orderRepository.save(order);
    }

    public void deliverOrder(Order order){
        order.setStatus(OrderStatus.Delivered);
    }

    public void returnOrder(Order order){
        order.setStatus(OrderStatus.Returned);
    }

    public void deleteProductFromOrder(Product product, Order order) throws OrderStatusException {
        if(order.getStatus().equals(OrderStatus.Placed)) {
            order.getProductIds().remove(product.getId());
            if(order.getProductIds() == null){
                deleteOrder(order.getId());
            }
        } else {
            throw new OrderStatusException("Invalid order status");
        }
    }

    private void deleteOrder(Long orderId){
        orderRepository.delete(orderId);
    }

    public void deleteAllProductsFromOrder(Order order) {
        order.getProductIds().clear();
    }

}

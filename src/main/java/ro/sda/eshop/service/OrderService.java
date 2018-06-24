package ro.sda.eshop.service;

import ro.sda.eshop.exception.MissingProductFromOrderException;
import ro.sda.eshop.exception.OrderStatusException;
import ro.sda.eshop.model.Order;
import ro.sda.eshop.model.OrderStatus;
import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.impl.OrderRepositoryImpl;
import ro.sda.eshop.view.displayer.OrderDisplayer;
import ro.sda.eshop.view.reader.ProductReader;
import ro.sda.eshop.view.reader.impl.ProductReaderImpl;

public class OrderService {

    OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
    OrderDisplayer orderDisplayer =  new OrderDisplayer();
    ProductReaderImpl productReader = new ProductReaderImpl();

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

    public void deleteProductFromOrder(Order order) throws OrderStatusException, MissingProductFromOrderException {
        Long productId = Long.valueOf(productReader.readProductId());
        if(order.getStatus().equals(OrderStatus.Pending)) {
            if(order.getProductIds().contains(productId)) {
                order.getProductIds().remove(productId);
            } else{
                throw new MissingProductFromOrderException("Product not found in order");
            }
            if(order.getProductIds() == null){
                orderRepository.delete(order.getId());
            }
        } else {
            throw new OrderStatusException("Invalid order status");
        }
    }

        public void deleteAllProductsFromOrder(Order order) {
        order.getProductIds().clear();
        orderRepository.delete(order.getId());
    }

}

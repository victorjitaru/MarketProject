package ro.sda.eshop.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private List<Long> productIds = new ArrayList<Long>();
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getProductsId() {
        return productIds;
    }

    public void setProducts(List<Long> productsId) {
        this.productIds = productsId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

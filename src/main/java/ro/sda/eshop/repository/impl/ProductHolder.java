package ro.sda.eshop.repository.impl;

import ro.sda.eshop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductHolder {

    private Map<Long, Product> products = new HashMap<Long, Product>();

    protected Long getMaxId(){
        Long maxId = -1L;
        for(Long key:products.keySet()){
            if(key > maxId){
                maxId = key;
            }
        }
        return maxId;
    }

    public void addProduct(Product product){
        this.products.put(product.getId(),product);
    }

    public void setProducts(List<Product> products){
        this.products.clear();
        for(Product product:products){
            this.products.put(product.getId(), product);
        }
    }

    public Product getProduct(long id){
     return this.products.get(id);
    }

    public List<Product> getAllProducts(){
        return new ArrayList<Product>(this.products.values());
    }
}

package ro.sda.eshop.service;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.impl.ProductRepositoryImpl;
import ro.sda.eshop.view.displayer.ProductDisplayer;

import java.util.List;

public class ProductService {

    ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
    List<Product> products = productRepositoryImpl.findAll();
    ProductDisplayer productDisplayer = new ProductDisplayer();

    public Long getIdForProduct(Product product) {
        return product.getId();
    }

    public boolean productExists(Product product) {
        for (Product prod : products) {
            if (product.equals(prod)) {
                return true;
            }
        }
        return false;
    }

    public void listProducts(){
        productDisplayer.listProducts(products);
    }

    public void addProduct(Product product) {
            productRepositoryImpl.save(product);
    }

    public Product getProductById(Long productId) {
        return productRepositoryImpl.find(productId);
    }

    public void deleteProduct(Long productId){
        productRepositoryImpl.delete(productId);
    }
}

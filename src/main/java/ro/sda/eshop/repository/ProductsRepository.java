package ro.sda.eshop.repository;

import ro.sda.eshop.model.Product;

import java.util.List;

/*
* TODO: rename to ProductRepository
* */
public interface ProductsRepository {

    List<Product> getAllProducts();
    Product getProductById(long id);
    void persistProduct(Product product);
    void persistProducts(List<Product> products);

}

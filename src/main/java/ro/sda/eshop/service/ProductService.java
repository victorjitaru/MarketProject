package ro.sda.eshop.service;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.reader.impl.ProductReaderImpl;
import ro.sda.eshop.repository.impl.ProductsRepositoryImpl;

import java.util.List;

public class ProductService {

    ProductsRepositoryImpl productsRepositoryImpl = new ProductsRepositoryImpl();
    ProductReaderImpl productReader = new ProductReaderImpl();
    List<Product> products = productsRepositoryImpl.getAllProducts();



    //read ID for a Product
    public Long getIdForProduct() {
        return productReader.readProductId();
    }

    public boolean productExists(Product product) {
        for (Product prod : products) {
            if (product.equals(prod)) {
                return true;
            }
        }
        return false;
    }
}

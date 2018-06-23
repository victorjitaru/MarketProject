package ro.sda.eshop.service;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.impl.ProductRepositoryImpl;

import java.util.List;

public class ProductService {

    ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
    List<Product> products = productRepositoryImpl.getAllProducts();

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

    public void listProducts() {
        List<Product> products = productRepositoryImpl.getAllProducts();
        for (Product product : products) {
            /*
            * TODO: call sout with toString - DONE
            * */
            System.out.println(product.toString());
        }
    }

    /*
     * TODO: add Product param and call persistProduct with that product - DONE
     * */
    public void addProduct(Product product) {
        productRepositoryImpl.persistProduct(product);
    }

    /*
     * TODO: remove - DONE
     * */

    /*
     * TODO: rename param to productId - DONE
     * */
    public Product getProductById(Long productId) {
        return productRepositoryImpl.getProductById(productId);
    }

}

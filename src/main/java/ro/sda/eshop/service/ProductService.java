package ro.sda.eshop.service;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.reader.impl.ProductReaderImpl;
import ro.sda.eshop.repository.impl.ProductsRepositoryImpl;

import java.util.List;

public class ProductService {

    ProductsRepositoryImpl productsRepositoryImpl = new ProductsRepositoryImpl();
    List<Product> products = productsRepositoryImpl.getAllProducts();

    /*
     * TODO: remove
     * */
    ProductReaderImpl productReader = new ProductReaderImpl();

    //read ID for a Product
    /*
     * TODO: remove
     * */
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

    public void listProducts() {
        List<Product> products = productsRepositoryImpl.getAllProducts();
        for (Product product : products) {
            /*
            * TODO: call sout with toString
            * */
            product.toString();
            System.out.println();
        }
    }

    /*
     * TODO: add Product param and call persistProduct with that product
     * */
    public void addProduct() {
        productsRepositoryImpl.persistProduct(readProduct());
    }

    /*
     * TODO: remove
     * */
    public Product readProduct() {
        Product product = productReader.readProduct();
        if (!productExists(product)) {
            return product;
        }
        return null;
    }

    /*
     * TODO: rename param to productId
     * */
    public Product getProductById(Long id) {
        return productsRepositoryImpl.getProductById(id);
    }

}

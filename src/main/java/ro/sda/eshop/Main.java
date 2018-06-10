package ro.sda.eshop;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.reader.ProductReader;
import ro.sda.eshop.reader.impl.ProductReaderImpl;
import ro.sda.eshop.repository.ProductsRepository;
import ro.sda.eshop.repository.impl.ProductsRepositoryImpl;

public class Main {

    public static void main (String[] args) {
        ProductReader pread = new ProductReaderImpl();
        Product prod1 = pread.readProduct();
        Product prod2 = pread.readProduct();
        ProductsRepository productsRepository = new ProductsRepositoryImpl();
        productsRepository.persistProduct(prod1);
        productsRepository.persistProduct(prod2);


    }
}

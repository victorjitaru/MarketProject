package ro.sda.eshop;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.model.Stock;
import ro.sda.eshop.reader.ProductReader;
import ro.sda.eshop.reader.StockReader;
import ro.sda.eshop.reader.impl.ProductReaderImpl;
import ro.sda.eshop.reader.impl.StockReaderImpl;
import ro.sda.eshop.repository.ProductsRepository;
import ro.sda.eshop.repository.StockRepository;
import ro.sda.eshop.repository.impl.ProductsRepositoryImpl;
import ro.sda.eshop.repository.impl.StockRepositoryImpl;

public class Main {

    public static void main (String[] args) {
        ProductReader pread = new ProductReaderImpl();
        Product prod1 = pread.readProduct();
        Product prod2 = pread.readProduct();
        ProductsRepository productsRepository = new ProductsRepositoryImpl();
        productsRepository.persistProduct(prod1);
        productsRepository.persistProduct(prod2);

        StockReader sread = new StockReaderImpl();
        Stock stock1 = sread.readStock();
        Stock stock2 = sread.readStock();
        StockRepository stocksRepository = new StockRepositoryImpl();
        stocksRepository.persistStock(stock1);
        stocksRepository.persistStock(stock2);

        }
}

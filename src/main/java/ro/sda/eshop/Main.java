package ro.sda.eshop;

import ro.sda.eshop.view.GeneralView;

public class Main {

    public static void main (String[] args) {
//        ProductReader pread = new ProductReaderImpl();
//        Product prod1 = pread.readProduct();
//        Product prod2 = pread.readProduct();
//        ProductRepository productsRepository = new ProductRepositoryImpl();
//        productsRepository.persistProduct(prod1);
//        productsRepository.persistProduct(prod2);
//
//        StockReader sread = new StockReaderImpl();
//        Stock stock1 = sread.readStock();
//        Stock stock2 = sread.readStock();
//        StockRepository stocksRepository = new StockRepositoryImpl();
//        stocksRepository.persistStock(stock1);
//        stocksRepository.persistStock(stock2);
//
//        OrderReader orderRead = new OrderReaderImpl();
//        OrderService orderService = new OrderService();
//        Order ord1 = orderRead.readOrder();
//        Order ord2 = orderRead.readOrder();
//        orderService.addProdToOrder(prod1, ord1);
//        orderService.addProdToOrder(prod2, ord1);

//        orderService.placeOrder(ord1);
//        orderService.placeOrder(ord2);

        GeneralView generalView = new GeneralView();
        generalView.displayView();

    }

}

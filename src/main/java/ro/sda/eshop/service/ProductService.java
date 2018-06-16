package ro.sda.eshop.service;

import ro.sda.eshop.repository.impl.ProductsRepositoryImpl;

public class ProductService {

    ProductsRepositoryImpl productsRepositoryImpl = new ProductsRepositoryImpl();

//    public void showDetailedProduct(long id){
//        ProductView productView = new ProductView();
//        productView.displayDetailedProduct(productsRepositoryImpl.getProductById(id));
//    }
//
////Gets all products from ProdRepository and uses View/ListProdView to display them
//    public void showProductList(){
//        List<Product> products = productsRepositoryImpl.getAllProducts();
//        ListProductsView listProductsView = new ListProductsView();
//        listProductsView.displayListOfProducts(products);
//    }
}

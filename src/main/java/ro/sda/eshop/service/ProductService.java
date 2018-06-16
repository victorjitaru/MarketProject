package ro.sda.eshop.service;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.impl.ProductsRepositoryImpl;
import ro.sda.eshop.view.ListProductsView;
import ro.sda.eshop.view.ProductView;

import java.util.List;

public class ProductService {

    ProductsRepositoryImpl productsRepositoryImpl = new ProductsRepositoryImpl();

    public void showDetailedProduct(long id){
        ProductView productView = new ProductView();
        productView.displayDetailedProduct(productsRepositoryImpl.getProductById(id));
    }

//Gets all products from ProdRepository and uses View/ListProdView to display them
    public void showProductList(){
        List<Product> products = productsRepositoryImpl.getAllProducts();
        ListProductsView listProductsView = new ListProductsView();
        listProductsView.displayListOfProducts(products);
    }
}

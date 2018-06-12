package ro.sda.eshop.service;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.service.view.ListProductsView;
import ro.sda.eshop.service.view.ProductView;

import java.util.List;

public class ProductService {
    public void showProduct(Product product){
        ProductView productView = new ProductView();
        productView.displayDetailedProduct(product);
    }

    public void showProductList(List<Product> products){
        ListProductsView listProductsView = new ListProductsView();
        listProductsView.displayListOfProducts(products);
    }

}

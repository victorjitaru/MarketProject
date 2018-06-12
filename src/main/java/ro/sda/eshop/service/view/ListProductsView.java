package ro.sda.eshop.service.view;

import ro.sda.eshop.model.Product;

import java.util.List;

public class ListProductsView {
    public void displayListOfProducts(List<Product> products){
        for(Product product:products){
            displayMinimumInfoProduct(product);
        }

    }
    private void displayMinimumInfoProduct(Product product){
        System.out.println(product.getName() + "(" + product.getPrice() + ") \n");
    }
}

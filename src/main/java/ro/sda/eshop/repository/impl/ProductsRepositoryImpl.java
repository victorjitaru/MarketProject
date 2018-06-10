package ro.sda.eshop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.ProductsRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductsRepositoryImpl implements ProductsRepository {

    public static final String filePath = "C:\\Users\\jitar\\ProjectsSDAcad\\MarketProject\\products.json";
    ProductHolder productHolder = new ProductHolder();

    public List<Product> getAllProducts() {
        return null;
    }

    public Product getProductById(long id) {
        return null;
    }

    public void persistProduct(Product product) {
        product.setId(productHolder.getMaxId() + 1);
        productHolder.addProduct(product);
        serialize(productHolder.getAllProducts());
    }

    private void serialize(List<Product> products){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String productsLiteral =  gson.toJson(products);
        writeToFile(productsLiteral);
    }

    private void writeToFile(String products){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(products);
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.close();
        }catch (IOException e){
            e.getMessage();
        }
    }

    public void persistProducts(List<Product> products) {
        serialize(products);
    }
}

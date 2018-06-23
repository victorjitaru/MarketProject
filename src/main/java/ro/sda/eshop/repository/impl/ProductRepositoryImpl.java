package ro.sda.eshop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.ProductRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* TODO: rename to ProductRepositoryImpl - DONE
* */
public class ProductRepositoryImpl implements ProductRepository {

    public static final String FILE_PATH = "products.json";
    ProductHolder productHolder = new ProductHolder();

    /*
    * TODO: write productHolder.setAllProducts(readFromFile())
    * */
    public ProductRepositoryImpl(){
        readFromFile();
    }

    public List<Product> getAllProducts() {
        return readFromFile();
    }

    /*
    * TODO: take product from holder - DONE
    * productHolder.getProduct(productId)
    * */
    public Product getProductById(long productId) {
        return productHolder.getProduct(productId);
    }

    //assigns an Id to the products and adds a prod to the product list
    public void persistProduct(Product product) {
        product.setId(productHolder.getMaxId() + 1);
        productHolder.addProduct(product);
        serialize(productHolder.getAllProducts());
    }

    private void serialize(List<Product> products) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String productsLiteral = gson.toJson(products);
        writeToFile(productsLiteral);
    }

    //writes a product into the json file
    private void writeToFile(String products) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            fileWriter.write(products);
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //reading the products from a json file in order to have the list with all the products
    private List<Product> readFromFile() {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                sb.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.getMessage();
        }

        String productsLiteral = sb.toString();
        Gson gson = new Gson();

        List<Product> myProducts = new ArrayList<Product>();
        myProducts = gson.fromJson(productsLiteral, myProducts.getClass());
        return myProducts;
    }

    public void persistProducts(List<Product> products) {
        serialize(products);
    }


}

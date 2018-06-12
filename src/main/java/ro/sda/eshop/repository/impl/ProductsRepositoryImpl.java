package ro.sda.eshop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.eshop.model.Product;
import ro.sda.eshop.repository.ProductsRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductsRepositoryImpl implements ProductsRepository {

    public static final String FILE_PATH = "C:\\Users\\jitar\\ProjectsSDAcad\\MarketProject\\products.json";
    ProductHolder productHolder = new ProductHolder();

    public List<Product> getAllProducts() {
        return readFromFile();
    }

    public Product getProductById(long id) {
        List<Product> products = readFromFile();
        for(Product product:products){
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }
//assigns an Id to the products and adds a prod to the product list
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
//writes a product into the json file
    private void writeToFile(String products){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            fileWriter.write(products);
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.close();
        }catch (IOException e){
            e.getMessage();
        }
    }
//reading the products from a json file in order to have the list with all the products
    private List<Product> readFromFile(){
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(bufferedReader.ready()) {
                sb.append(bufferedReader.readLine());
            }
        }catch (IOException e){
            e.getMessage();
        }
        String productsLiteral = sb.toString();
        Gson gson = new Gson();
        return Arrays.asList(gson.fromJson(productsLiteral, Product.class));
    }

    public void persistProducts(List<Product> products) {
        serialize(products);
    }
}

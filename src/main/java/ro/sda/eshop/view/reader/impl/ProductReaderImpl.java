package ro.sda.eshop.view.reader.impl;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.view.reader.ProductReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class ProductReaderImpl implements ProductReader{

    //reads a product from the keyboard
    public Product readProduct() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        product.setName(scanner.nextLine());
        System.out.print("Price: ");
        product.setPrice(scanner.nextBigDecimal());
        System.out.print("Description: ");
        System.out.println();
        product.setDescription(scanner.nextLine());

        return product;
    }

    //reads products from a file
    public Product addProductsFromFile(){
        String sourceFilePath = "productSource.txt";
        Product product = new Product();
        try {
            FileReader fileReader = new FileReader(sourceFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(bufferedReader.ready()){
                product.setName(bufferedReader.readLine());
                product.setPrice(new BigDecimal(String.valueOf(bufferedReader.readLine())));
                product.setDescription(bufferedReader.readLine());
            }
        } catch (IOException e){
            e.getMessage();
        }

        return product;
    }

    public String readProductId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Product Id: ");
        return scanner.nextLine();
    }


}

package ro.sda.eshop.reader.impl;

import ro.sda.eshop.model.Product;
import ro.sda.eshop.reader.ProductReader;

import java.util.Scanner;

public class ProductReaderImpl implements ProductReader{
    public Product readProduct() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        product.setName(scanner.nextLine());
        System.out.print("Price: ");
        product.setPrice(scanner.nextBigDecimal());
        System.out.print("Description: ");
        System.out.println(" ");
        product.setDescription(scanner.nextLine());
        return product;
    }
}

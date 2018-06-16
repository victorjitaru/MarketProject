package ro.sda.eshop;

import org.junit.Test;
import ro.sda.eshop.model.Product;
import ro.sda.eshop.reader.impl.ProductReaderImpl;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class ReadingProdsFromFileTest {

    Product product;
    ProductReaderImpl productReader = new ProductReaderImpl();

    @Test
    public void testReadFromFile() {
        String expected = "Toast\n" + "(" + BigDecimal.valueOf(2.87) + ") \n" + "Product details\n" +  "The best bread you will find on this side of the solar system.";
        Product product = productReader.addProductsFromFile();
        String result = product.toString();
        assertEquals(expected, result);
    }

}

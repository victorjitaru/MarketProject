package ro.sda.eshop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.eshop.model.Order;
import ro.sda.eshop.repository.OrderRepository;
import ro.sda.eshop.service.OrderService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    public static final String FILE_PATH = "C:\\Users\\jitar\\ProjectsSDAcad\\MarketProject\\orders.json";
    OrderHolder orderHolder = new OrderHolder();
    OrderService orderService = new OrderService();

    public List<Order> getAll() {
        return readFromFile();
    }

    public Order getOrderById(long id) {
        List<Order> orders = readFromFile();
        for(Order order:orders){
            if(order.getId() == id){
                return order;
            }
        }
        return null;
    }

    public void persistOrder(Order order) {

        if(order.getId() == null){
            order.setId(orderHolder.getMaxId() + 1);
        }

        orderHolder.addOrder(order);
        serialize(orderHolder.getAllOrders());
    }

    public void persistAllOrders(List<Order> orders) {
        serialize(orders);
    }

    private void writeToFile(String orders){
        try{
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            fileWriter.write(orders);
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.close();
        }catch (IOException e){
            e.fillInStackTrace();
        }
    }

    private List<Order> readFromFile(){
        StringBuilder stringBuilder = new StringBuilder();
        try{
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()){
                stringBuilder.append(bufferedReader.readLine());
            }
        } catch (IOException e){
            e.fillInStackTrace();
        }

        String ordersLiteral = stringBuilder.toString();
        Gson gson = new Gson();
        return Arrays.asList(gson.fromJson(ordersLiteral, Order.class));
    }

    private void serialize(List<Order> orders){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String ordersLiteral = gson.toJson(orders);
        writeToFile(ordersLiteral);
    }

}

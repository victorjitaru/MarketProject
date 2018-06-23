package ro.sda.eshop.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ro.sda.eshop.model.Order;
import ro.sda.eshop.repository.OrderRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    public static final String FILE_PATH = "orders.json";
    OrderHolder orderHolder = new OrderHolder();

    public OrderRepositoryImpl(){
        this.orderHolder.setAllOrders(readFromFile());
    }

    public List<Order> getAll() {
        return orderHolder.getAllOrders();
    }

    public Order getOrderById(long orderId) {
        return orderHolder.getOrder(orderId);
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
        List<Order> myOrders = new ArrayList<Order>();
        myOrders = gson.fromJson(ordersLiteral, myOrders.getClass());
        return myOrders;
    }

    private void serialize(List<Order> orders){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String ordersLiteral = gson.toJson(orders);
        writeToFile(ordersLiteral);
    }

    public void deleteOrder(Order order){
        orderHolder.deleteOrder(order);
    }
}

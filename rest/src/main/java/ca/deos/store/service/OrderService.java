package ca.deos.store.service;

import ca.deos.store.entity.Order;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.List;

public interface OrderService {

    List<Order> getOrders();

    Order getOrder(int orderId);

    List<Order> getUserOrders(String userId);

    List<Order> getRestaurantOrders(int resId);

    Order saveOrUpdateOrder(Order order) throws UnirestException;

    void deleteOrder(int orderId);


}

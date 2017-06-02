package ca.deos.store.dao;

import ca.deos.store.entity.Order;

import java.util.List;


public interface OrderDao {

    List<Order> getOrders();

    List<Order> gesRestaurantOrders(int resId);

    List<Order> getUserOrders(String userId);

    Order getOrder(int orderId);

    void saveOrUpdateOrder(Order order);

    void deleteOrder(int orderId);
}

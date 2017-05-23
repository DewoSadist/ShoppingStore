package ca.deos.store.dao;

import ca.deos.store.entity.Order;

import java.util.List;


public interface OrderDao {

    List<Order> getOrders();

    Order getOrder(int orderId);

    List<Order> getUserOrders(String userId);

    void saveOrUpdateOrder(Order order);

    void deleteOrder(int orderId);
}

package ca.deos.store.service.impl;

import ca.deos.store.dao.OrderDao;
import ca.deos.store.entity.Order;
import ca.deos.store.service.OrderService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 18.05.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    public Order getOrder(int orderId) {
        Order order = orderDao.getOrder(orderId);
        return order;
    }

    @Override
    public List<Order> getUserOrders(String userId) {
        return orderDao.getUserOrders(userId);
    }

    @Override
    public List<Order> getRestaurantOrders(int resId) {
        return orderDao.gesRestaurantOrders(resId);
    }

    @Override
    public Order saveOrUpdateOrder(Order order) throws UnirestException {
        orderDao.saveOrUpdateOrder(order);
        return order;
    }

    @Override
    public void deleteOrder(int orderId) {
        orderDao.deleteOrder(orderId);

    }
}

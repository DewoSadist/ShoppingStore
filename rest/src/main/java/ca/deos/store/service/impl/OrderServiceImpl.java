package ca.deos.store.service.impl;

import ca.deos.mail.EmailClient;
import ca.deos.mail.service.ReceiptService;
import ca.deos.store.dao.OrderDao;
import ca.deos.store.domain.EmailObject;
import ca.deos.store.entity.Order;
import ca.deos.store.service.OrderService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    EmailClient emailClient;

    @Autowired
    ReceiptService receiptService;

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
    public Order saveOrUpdateOrder(Order order) throws UnirestException, IOException {

        orderDao.saveOrUpdateOrder(order);

        // send Email
        String body = receiptService.getReceiptOrder(order);

        EmailObject mail = new EmailObject();
        mail.setDestinationAddress(order.getClient_email());
        mail.setBody(body);
        mail.setSubject("Order: "+ order.getId() + " from Munchrocket");

        emailClient.sendEmail(mail);

        return order;
    }

    @Override
    public void deleteOrder(int orderId) {
        orderDao.deleteOrder(orderId);

    }
}

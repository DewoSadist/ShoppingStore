package ca.deos.store.controller;

import ca.deos.store.entity.Order;
import ca.deos.store.service.OrderService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping(value = "/api")
public class OrderController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getAllOrders() throws IOException, UnirestException {

        return orderService.getOrders();
    }

    @ResponseBody
    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable int orderId) throws IOException, UnirestException {

        return orderService.getOrder(orderId);
    }

    @ResponseBody
    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public Order saveOrder(@RequestBody Order order) throws IOException, UnirestException {

        return orderService.saveOrUpdateOrder(order);
    }

    @ResponseBody
    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable int orderId) throws IOException, UnirestException {

        orderService.deleteOrder(orderId);

    }

    @ResponseBody
    @RequestMapping(value = "/users/{userId}/orders", method = RequestMethod.GET)
    public List<Order> getOrdersByUserId(@PathVariable String userId) throws Exception, UnirestException {
        return orderService.getUserOrders(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/restaurants/{resId}/orders", method = RequestMethod.GET)
    public List<Order> getOrdersByResId(@PathVariable int resId) throws Exception, UnirestException {
        return  orderService.getRestaurantOrders(resId);
    }
}

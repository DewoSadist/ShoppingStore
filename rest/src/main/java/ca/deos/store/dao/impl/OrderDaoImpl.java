package ca.deos.store.dao.impl;

import ca.deos.store.dao.OrderDao;
import ca.deos.store.entity.Order;
import ca.deos.store.entity.OrderDetails;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by admin on 17.05.2017.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    private Log log = LogFactory.getLog(RestaurantDaoImpl.class);

    @Autowired
    EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrders() {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Order.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> gesRestaurantOrders(int resId){
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Order.class)
                .add(Restrictions.eq("res_id", resId))
                .list();
    }

    @Override
    @Transactional
    public void saveOrUpdateOrder(Order order){
        Session session = em.unwrap(Session.class);
        if(order.getId() > 0){
            log.info("Updating existing order");
            List<OrderDetails> orderDetailses = order.getOrderDetails();
            order.setOrderDetails(null);
            session.update(order);
            for(OrderDetails od: orderDetailses){
                od.setOrder(order);
                System.out.println(od.toString());
                session.saveOrUpdate(od);
            }
            order.setOrderDetails(orderDetailses);
        } else {
            try {
                log.info("Inserting new order");
                List<OrderDetails> orderDetailses = order.getOrderDetails();
                order.setOrderDetails(null);
                session.save(order);
                for(OrderDetails od: orderDetailses){
                    od.setOrder(order);
                    System.out.println(od.toString());
                    session.save(od);
                }
                order.setOrderDetails(orderDetailses);
            } catch (Exception e){

            }
        }
        log.info("Order saved with id: " + order.getId());
    }
    @Override
    @Transactional(readOnly = true)
    public Order getOrder(int orderId){
        Session session = em.unwrap(Session.class);

        return (Order) session.get(Order.class, orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getUserOrders(String userId) {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Order.class)
                .add(Restrictions.eq("user_id", userId))
                .list();

    }



    @Override
    @Transactional
    public void deleteOrder(int orderId){
        Session session = em.unwrap(Session.class);

        Order order = (Order) session.load(Order.class, orderId);
        if(order != null) {
            session.delete(order);
        }
        log.info("Order deleted with id: " + orderId);
    }


}

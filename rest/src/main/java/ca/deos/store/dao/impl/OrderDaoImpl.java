package ca.deos.store.dao.impl;

import ca.deos.store.dao.OrderDao;
import ca.deos.store.entity.Order;
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
    @Transactional
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
    public void saveOrUpdateOrder(Order order){
        Session session = em.unwrap(Session.class);

        if(order.getId() > 0){
            session.update(order);
            log.info("Updating existing order");
        } else {
            session.save(order);
            log.info("Updating existing order");
        }
        log.info("Order saved with id: " + order.getId());
    }

    @Override
    @Transactional
    public void deleteOrder(int orderId){
        Session session = em.unwrap(Session.class);

        Order order = (Order) session.load(Order.class, orderId);
        if(order != null) {
            session.delete(order);
        }
    }
}

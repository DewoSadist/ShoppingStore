package ca.deos.store.dao.impl;

import ca.deos.store.dao.OrderDao;
import ca.deos.store.entity.Order;
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

    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public List<Order> getOrders() {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Order.class).list();
    }

    @Override
    @Transactional
    public Order getOrder(int orderId){
        Session session = em.unwrap(Session.class);

        return (Order) session.get(Order.class, orderId);
    }

    @Override
    @Transactional
    public List<Order> getUserOrders(String userId) {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Order.class).add(Restrictions.eq(userId, userId)).list();

    }

    @Override
    @Transactional
    public void saveOrUpdateOrder(Order order){
        Session session = em.unwrap(Session.class);

        session.saveOrUpdate(order);
    }

    @Override
    @Transactional
    public void deleteOrder(int orderId){
        Session session = em.unwrap(Session.class);

        Order order = (Order) session.load(Order.class, orderId);
        session.delete(order);

    }
}

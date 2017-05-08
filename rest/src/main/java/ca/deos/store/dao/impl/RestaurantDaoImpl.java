package ca.deos.store.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import ca.deos.store.dao.RestaurantDao;
import ca.deos.store.entity.Restaurant;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class RestaurantDaoImpl implements RestaurantDao {

    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public List<Restaurant> getRestaurants() {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Restaurant.class).list();
    }

    @Override
    @Transactional
    public Restaurant getRestaurantById(int resId){
        Session session = em.unwrap(Session.class);

        return (Restaurant) session.get(Restaurant.class, resId);
    }

    @Override
    @Transactional
    public void saveOrUpdateRestaurant(Restaurant restaurant) {
        Session session = em.unwrap(Session.class);

        session.saveOrUpdate(restaurant);
    }

    @Override
    @Transactional
    public void deleteRestaurant(int resId) {
        Session session = em.unwrap(Session.class);

        Restaurant restaurant = (Restaurant) session.load(Restaurant.class, resId);

        if(restaurant != null) {
            session.delete(restaurant);
        }
    }

    @Override
    @Transactional
    public List<Restaurant> getRestaurantByUserId(String userId){
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Restaurant.class).add(Restrictions.eq("user_id", userId)).list();
    }
}

package ca.deos.store.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import ca.deos.store.dao.RestaurantDao;
import ca.deos.store.entity.Hour;
import ca.deos.store.entity.Restaurant;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class RestaurantDaoImpl implements RestaurantDao {

    private Log log = LogFactory.getLog(RestaurantDaoImpl.class);

    @Autowired
    EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Restaurant> getRestaurants() {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Restaurant.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public Restaurant getRestaurantById(int resId){
        Session session = em.unwrap(Session.class);

        return (Restaurant) session.get(Restaurant.class, resId);
    }

    @Override
    @Transactional
    public void saveOrUpdateRestaurant(Restaurant restaurant) {
        Session session = em.unwrap(Session.class);
        if (restaurant.getId() == null) {
            try{
                log.info("Inserting new restaurant");
                List<Hour> hours = restaurant.getHours();
                restaurant.setHours(null);
                session.save(restaurant);
                for(Hour ch: hours){
                    ch.setRestaurant(restaurant);
                    System.out.println(ch.toString());
                    session.save(ch);
                }
                restaurant.setHours(hours);

            } catch (Exception e) {
            }
        } else {
            List<Hour> hours = restaurant.getHours();
            session.update(restaurant);
            for(Hour ch: hours){
                ch.setRestaurant(restaurant);
                System.out.println(ch.toString());
                session.update(ch);
            }

            log.info("Updating existing restaurant");
        }
        log.info("Restaurant saved with id: " + restaurant.getId());
    }

    @Override
    @Transactional
    public void deleteRestaurant(int resId) {
        Session session = em.unwrap(Session.class);

        Restaurant restaurant = (Restaurant) session.load(Restaurant.class, resId);

        if(restaurant != null) {
            session.delete(restaurant);
        }
        log.info("Restaurant deleted with id: " + resId);
    }

    @Override
    @Transactional
    public List<Restaurant> getRestaurantByUserId(String userId){
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Restaurant.class)
                .add(Restrictions.eq("user_id", userId))
                .list();
    }
}

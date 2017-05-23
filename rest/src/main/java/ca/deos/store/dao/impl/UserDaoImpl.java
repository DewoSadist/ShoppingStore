package ca.deos.store.dao.impl;

import ca.deos.store.dao.UserDao;
import ca.deos.store.entity.Hour;
import ca.deos.store.entity.Restaurant;
import ca.deos.store.entity.User;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public User getUserByLogin(String login) throws UnirestException, IOException {
        Session session = em.unwrap(Session.class);
        return (User) session.get(User.class, login);
    }


    @Override
    @Transactional
    public User getUser(String userId) throws UnirestException, IOException {
        Session session = em.unwrap(Session.class);

        return (User) session.createCriteria(User.class)
                .add(Restrictions.eq("user_id", userId))
                .uniqueResult();
    }

    @Override
    @Transactional
    public void deleteUser(String userId) throws UnirestException, IOException {
        Session session = em.unwrap(Session.class);

        User user = (User) session.load(User.class,userId);
        session.delete(user);

    }

    @Override
    @Transactional
    public void saveOrUpdateUser(User user) throws UnirestException, IOException {
        Session session = em.unwrap(Session.class);

        session.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void createUser(User user) throws UnirestException, IOException {
        Session session = em.unwrap(Session.class);

        session.save(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(User.class).list();
    }
}

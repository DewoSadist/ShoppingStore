package ca.deos.store.dao.impl;

import ca.deos.store.dao.HourDao;
import ca.deos.store.entity.Hour;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HourDaoImpl implements HourDao {

    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public List<Hour> getHours() {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Hour.class).list();
    }

    @Override
    @Transactional
    public List<Hour> getRestaurantHours(int resId){
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Hour.class).add(Restrictions.eq("res_id", resId)).list();
    }

    @Override
    @Transactional
    public void saveOrUpdateHour(Hour hour) {
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(hour);

    }

    @Override
    @Transactional
    public void deleteHour(int openId) {
        Session session = em.unwrap(Session.class);

        Hour hour = (Hour) session.load(Hour.class,openId);
        session.delete(hour);

    }
}

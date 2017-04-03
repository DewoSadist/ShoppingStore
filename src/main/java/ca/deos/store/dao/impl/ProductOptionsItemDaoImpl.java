package ca.deos.store.dao.impl;

import ca.deos.store.dao.ProductOptionsItemDao;
import ca.deos.store.entity.ProductOptionsItem;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class ProductOptionsItemDaoImpl implements ProductOptionsItemDao {

    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public List<ProductOptionsItem> getProductOptionsItem() {
        Session session = em.unwrap(Session.class);
        return session.createCriteria(ProductOptionsItem.class).list();
    }

    @Override
    @Transactional
    public ProductOptionsItem getProductOptionsItemById(int optId) {
        Session session = em.unwrap(Session.class);
        return (ProductOptionsItem) session.get(ProductOptionsItem.class, optId);
    }

    @Override
    @Transactional
    public void saveOrUpdateProductOptionsItem(ProductOptionsItem productOptionsItem) {
        Session session = em.unwrap(Session.class);

        session.saveOrUpdate(productOptionsItem);

    }

    @Override
    @Transactional
    public void deleteProductOptionsItem(int optId) {
        Session session = em.unwrap(Session.class);

        ProductOptionsItem productOptionsItem = (ProductOptionsItem) session.load(ProductOptionsItem.class, optId);

        if(productOptionsItem != null) {
            session.delete(productOptionsItem);
        }
    }
}

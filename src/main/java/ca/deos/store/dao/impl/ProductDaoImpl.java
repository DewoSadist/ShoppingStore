package ca.deos.store.dao.impl;

import ca.deos.store.dao.ProductDao;
import ca.deos.store.entity.Product;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public List<Product> getProducts() {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Product.class).list();
    }

    @Override
    @Transactional
    public Product getProductById(int prodId){
        Session session = em.unwrap(Session.class);

        return (Product) session.get(Product.class, prodId);
    }

    @Override
    @Transactional
    public  List<Product> getProductsByCatID(int catId) {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Product.class)
                .add(Restrictions.eq("cat_id", catId)).list();
    }
    @Override
    @Transactional
    public void saveOrUpdateProduct(Product product) {
        Session session = em.unwrap(Session.class);

        session.saveOrUpdate(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int resId) {
        Session session = em.unwrap(Session.class);

        Product product = (Product) session.load(Product.class, resId);

        if(product != null) {
            session.delete(product);
        }
    }
}

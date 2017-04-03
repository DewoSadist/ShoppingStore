package ca.deos.store.dao.impl;

import ca.deos.store.dao.ProductOptionsDao;
import ca.deos.store.entity.ProductOptions;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class ProductOptionsDaoImpl implements ProductOptionsDao {

    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public List<ProductOptions> getProductOptions() {
        Session session = em.unwrap(Session.class);
        return session.createCriteria(ProductOptions.class).list();
    }

    @Override
    @Transactional
    public ProductOptions getProductOptionsById(int optId) {
        Session session = em.unwrap(Session.class);
        return (ProductOptions) session.get(ProductOptions.class, optId);
    }

    @Override
    @Transactional
    public void saveOrUpdateProductOptions(ProductOptions productOptions) {
        Session session = em.unwrap(Session.class);

        session.saveOrUpdate(productOptions);

    }

    @Override
    @Transactional
    public void deleteProductOptions(int optId) {
        Session session = em.unwrap(Session.class);

        ProductOptions productOptions = (ProductOptions) session.load(ProductOptions.class, optId);

        if(productOptions != null) {
            session.delete(productOptions);
        }
    }
}

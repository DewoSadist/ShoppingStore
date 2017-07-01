package ca.deos.store.dao.impl;

import ca.deos.store.dao.ProductOptionsDao;
import ca.deos.store.entity.ProductOptions;
import ca.deos.store.entity.ProductOptionsItem;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class ProductOptionsDaoImpl implements ProductOptionsDao {

    private Log log = LogFactory.getLog(ProductOptionsDaoImpl.class);


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
    public List<ProductOptions> getProductOptionsListById(int prodId) {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(ProductOptions.class).add(Restrictions.eq("prod_id", prodId)).list();
    }

    @Override
    @Transactional
    public void saveOrUpdateProductOptions(List<ProductOptions> productOptionsList) {
        Session session = em.unwrap(Session.class);
        for(ProductOptions po: productOptionsList ){
            if(po.getId() > 0) {
                log.info("Updating existing options");
                List<ProductOptionsItem> productOptionsItems = po.getProductOptionsItems();
                po.setProductOptionsItems(null);
                session.update(po);
                for(ProductOptionsItem poi: productOptionsItems){
                    poi.setProductOptions(po);
                    session.saveOrUpdate(poi);
                }
                po.setProductOptionsItems(productOptionsItems);

            } else {
                log.info("Inserting new options");
                List<ProductOptionsItem> productOptionsItems = po.getProductOptionsItems();
                po.setProductOptionsItems(null);
                session.save(po);
                for(ProductOptionsItem poi: productOptionsItems){
                    poi.setProductOptions(po);
                    session.saveOrUpdate(poi);
                }
                po.setProductOptionsItems(productOptionsItems);

            }
        }

        log.info("Inserting new options");
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

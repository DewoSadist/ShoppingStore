package ca.deos.store.dao.impl;

import ca.deos.store.dao.CategoryDao;
import ca.deos.store.entity.Category;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    EntityManager em;

    @Override
    @Transactional
    public List<Category> getCategories() {
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Category.class).list();
    }
    @Override
    @Transactional
    public List<Category> getCategoriesByResId(int resId){
        Session session = em.unwrap(Session.class);

        return session.createCriteria(Category.class).
        add(Restrictions.eq("res_id", resId)).list();
    }

    @Override
    @Transactional
    public void saveOrUpdateCategory(Category category) {
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(category);
    }

    @Override
    @Transactional
    public void deleteCategory(int catId) {
        Session session = em.unwrap(Session.class);

        Category category = (Category) session.load(Category.class, catId);

        session.delete(category);
    }
}

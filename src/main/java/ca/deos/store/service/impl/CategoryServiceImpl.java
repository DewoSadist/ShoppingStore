package ca.deos.store.service.impl;


import ca.deos.store.dao.CategoryDao;
import ca.deos.store.entity.Category;
import ca.deos.store.service.CategoryService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    @Override
    public List<Category> getCategoriesByResId(int resId){
        return categoryDao.getCategoriesByResId(resId);
    }

    @Override
    public Category saveOrUpdateCategory(Category category) throws UnirestException {
        categoryDao.saveOrUpdateCategory(category);
        return category;
    }

    @Override
    public void deleteCategory(int catId) {
        categoryDao.deleteCategory(catId);
    }
}

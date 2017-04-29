package ca.deos.store.dao;

import ca.deos.store.entity.Category;

import java.util.List;

public interface CategoryDao {

    public List<Category> getCategories();

    public List<Category> getCategoriesByResId(int resId);

    public void saveOrUpdateCategory(Category category);

    public void deleteCategory(int catId);
}

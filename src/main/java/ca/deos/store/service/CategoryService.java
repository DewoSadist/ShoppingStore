package ca.deos.store.service;


import ca.deos.store.entity.Category;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface CategoryService {

    public List<Category> getCategories();

    public Category saveOrUpdateCategory(Category category) throws UnirestException;

    public void deleteCategory(int catId);

}

package ca.deos.store.controller;

import ca.deos.store.entity.Category;
import ca.deos.store.service.CategoryService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping(value = "/api")
public class CategoryController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/restaurants/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() throws IOException, UnirestException {

        return categoryService.getCategories();
    }

    @ResponseBody
    @RequestMapping(value = "/restaurants/categories", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Category saveCategory(@RequestBody Category category) throws IOException, UnirestException {

        return categoryService.saveOrUpdateCategory(category);
    }

    @ResponseBody
    @RequestMapping(value = "/restaurants/categories/{catId}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable int catId) throws IOException, UnirestException {

        categoryService.deleteCategory(catId);

    }
}

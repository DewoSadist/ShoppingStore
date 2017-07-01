package ca.deos.store.controller;

import ca.deos.store.entity.Product;
import ca.deos.store.service.ProductService;
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
public class ProductController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductService productService;

    @ResponseBody
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() throws IOException, UnirestException {

        return productService.getProducts();
    }
    @ResponseBody
    @RequestMapping(value = "/products/{prodId}", method = RequestMethod.GET)
    public  Product getProduct(@PathVariable int prodId) throws IOException, UnirestException {

        return productService.getProductById(prodId);
    }

    @ResponseBody
    @RequestMapping(value = "/categories/{catId}/products", method = RequestMethod.POST)
    public  List<Product> getCategoriesProducts(@PathVariable int catId) throws IOException, UnirestException {

        return productService.getProductsByCatID(catId);
    }

    @ResponseBody
    @RequestMapping(value = "/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProduct(@RequestBody Product product) throws IOException, UnirestException {

        return productService.saveOrUpdateProduct(product);
    }

    @ResponseBody
    @RequestMapping(value = "/products/{prodId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable int prodId) throws IOException, UnirestException {

        productService.deleteProduct(prodId);

    }
}

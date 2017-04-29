package ca.deos.store.service;


import ca.deos.store.entity.Product;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();

    public  Product getProductById(int prodId);

    public List<Product> getProductsByCatID(int catId);

    public Product saveOrUpdateProduct(Product product) throws UnirestException;

    public void deleteProduct(int prodId);

}

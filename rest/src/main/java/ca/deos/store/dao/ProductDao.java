package ca.deos.store.dao;

import ca.deos.store.entity.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> getProducts();

    public Product getProductById(int prodId);

    public List<Product> getProductsByCatID(int catId);

    public void saveOrUpdateProduct(Product product);

    public void deleteProduct(int prodId);
}

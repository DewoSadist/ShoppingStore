package ca.deos.store.dao;

import ca.deos.store.entity.Product;
import ca.deos.store.entity.Restaurant;

import java.util.List;

public interface ProductDao {

    public List<Product> getProducts();

    public void saveOrUpdateProduct(Product product);

    public void deleteProduct(int prodId);
}

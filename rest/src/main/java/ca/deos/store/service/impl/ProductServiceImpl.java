package ca.deos.store.service.impl;


import ca.deos.store.dao.ProductDao;
import ca.deos.store.entity.Product;
import ca.deos.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public  Product getProductById(int prodId){
        return productDao.getProductById(prodId);
    }

    @Override
    public List<Product> getProductsByCatID(int catId) {
        return productDao.getProductsByCatID(catId);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        productDao.saveOrUpdateProduct(product);
        return product;
    }

    @Override
    public void deleteProduct(int prodId) { productDao.deleteProduct(prodId);

    }
}

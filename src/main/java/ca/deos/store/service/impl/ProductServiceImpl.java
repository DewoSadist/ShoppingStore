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
    ProductDao Product;

    @Override
    public List<Product> getProducts() {
        return Product.getProducts();
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        Product.saveOrUpdateProduct(product);
        return product;
    }

    @Override
    public void deleteProduct(int prodId) { Product.deleteProduct(prodId);

    }
}

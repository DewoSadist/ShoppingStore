package ca.deos.store.service.impl;


import ca.deos.store.dao.ProductOptionsItemDao;
import ca.deos.store.entity.ProductOptionsItem;
import ca.deos.store.service.ProductOptionsItemService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOptionsItemServiceImpl implements ProductOptionsItemService {

    @Autowired
    ProductOptionsItemDao productOptionsItemDao;

    @Override
    public List<ProductOptionsItem> getProductOptionsItem() {
        return productOptionsItemDao.getProductOptionsItem();
    }

    @Override
    public ProductOptionsItem getProductOptionsItemById(int optId) {
        return productOptionsItemDao.getProductOptionsItemById(optId);
    }

    @Override
    public ProductOptionsItem saveOrUpdateProductOptionsItem(ProductOptionsItem productOptions) throws UnirestException {
        productOptionsItemDao.saveOrUpdateProductOptionsItem(productOptions);
        return productOptions;
    }

    @Override
    public void deleteProductOptionsItem(int optId) {productOptionsItemDao.deleteProductOptionsItem(optId);

    }
}

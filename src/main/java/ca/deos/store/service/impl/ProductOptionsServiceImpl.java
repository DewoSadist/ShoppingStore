package ca.deos.store.service.impl;


import ca.deos.store.dao.ProductOptionsDao;
import ca.deos.store.entity.ProductOptions;
import ca.deos.store.service.ProductOptionsService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOptionsServiceImpl implements ProductOptionsService {

    @Autowired
    ProductOptionsDao productOptionsDao;

    @Override
    public List<ProductOptions> getProductOptions() {
        return productOptionsDao.getProductOptions();
    }

    @Override
    public ProductOptions getProductOptionsById(int optId) {
        return productOptionsDao.getProductOptionsById(optId);
    }

    @Override
    public ProductOptions saveOrUpdateProductOptions(ProductOptions productOptions) throws UnirestException {
        productOptionsDao.saveOrUpdateProductOptions(productOptions);
        return productOptions;
    }

    @Override
    public void deleteProductOptions(int optId) {productOptionsDao.deleteProductOptions(optId);

    }
}

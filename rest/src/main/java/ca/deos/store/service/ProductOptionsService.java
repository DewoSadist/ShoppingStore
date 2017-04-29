package ca.deos.store.service;


import ca.deos.store.entity.ProductOptions;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface ProductOptionsService {

    public List<ProductOptions> getProductOptions();

    public ProductOptions getProductOptionsById(int optId);

    public List<ProductOptions> getProductOptionsListById(int prodId);

    public ProductOptions saveOrUpdateProductOptions(ProductOptions productOptions) throws UnirestException;

    public void deleteProductOptions(int optId);

}

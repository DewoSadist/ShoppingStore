package ca.deos.store.service;


import ca.deos.store.entity.ProductOptionsItem;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface ProductOptionsItemService {

    public List<ProductOptionsItem> getProductOptionsItem();

    public ProductOptionsItem getProductOptionsItemById(int optId);

    public ProductOptionsItem saveOrUpdateProductOptionsItem(ProductOptionsItem productOptionsItem) throws UnirestException;

    public void deleteProductOptionsItem(int optId);

}

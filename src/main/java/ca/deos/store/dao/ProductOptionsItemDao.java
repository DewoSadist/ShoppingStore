package ca.deos.store.dao;

import ca.deos.store.entity.ProductOptionsItem;

import java.util.List;

public interface ProductOptionsItemDao {

    public List<ProductOptionsItem> getProductOptionsItem();

    public ProductOptionsItem getProductOptionsItemById(int optId);

    public void saveOrUpdateProductOptionsItem(ProductOptionsItem productOptionsItem);

    public void deleteProductOptionsItem(int optId);
}

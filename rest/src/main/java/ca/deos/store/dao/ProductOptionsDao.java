package ca.deos.store.dao;

import ca.deos.store.entity.ProductOptions;

import java.util.List;

public interface ProductOptionsDao {

    public List<ProductOptions> getProductOptions();

    public ProductOptions getProductOptionsById(int optId);

    public List<ProductOptions> getProductOptionsListById(int prodId);

    public void saveOrUpdateProductOptions(List<ProductOptions> productOptionsList);

    public void deleteProductOptions(int optId);
}

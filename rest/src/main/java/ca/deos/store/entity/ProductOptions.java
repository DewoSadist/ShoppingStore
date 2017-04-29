package ca.deos.store.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_options")
public class ProductOptions {
    @Id
    @Column(name = "opt_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "isRequired")
    int isRequired;

    @Column(name = "isFree")
    int isFree;

    @Column(name = "isOne")
    int isOne;

    @Column(name = "prod_id")
    int prod_id;

    @OneToMany(mappedBy = "productOptions", fetch = FetchType.LAZY)
    private List<ProductOptionsItem> productOptionsItems;

    public List<ProductOptionsItem> getProductOptionsItems() {
        return productOptionsItems;
    }

    public void setProductOptionsItems(List<ProductOptionsItem> productOptionsItems) {
        this.productOptionsItems = productOptionsItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(int isRequired) {
        this.isRequired = isRequired;
    }

    public int getIsFree() {
        return isFree;
    }

    public void setIsFree(int isFree) {
        this.isFree = isFree;
    }

    public int getIsOne() {
        return isOne;
    }

    public void setIsOne(int isOne) {
        this.isOne = isOne;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    @Override
    public String toString() {
        return "ProductOptions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isRequired=" + isRequired +
                ", isFree=" + isFree +
                ", isOne=" + isOne +
                ", prod_id=" + prod_id +
                '}';
    }
}

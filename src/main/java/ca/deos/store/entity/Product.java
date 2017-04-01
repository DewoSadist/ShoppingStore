package ca.deos.store.entity;

import javax.persistence.*;
@Entity
@Table(name="product")
public class Product {
    @Id
    @Column(name = "prod_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "title")
    String title;

    @Column(name = "img_url")
    String img_url;

    @Column(name = "price")
    double price;

    @Column(name = "description")
    String description;

    @Column(name = "tags")
    String tags;

    @Column(name = "discount")
    int discount;

    @Column(name = "cus_id")
    int cus_id;

    @Column(name = "sup_id")
    int sup_id;

    @Column(name = "type_id")
    int type_id;

    @Column(name = "cat_id")
    int cat_id;

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

//    @ManyToOne
//    @JoinColumn(name = "cat_id")
//    Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discout) {
        this.discount = discout;
    }

    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public int getSup_id() {
        return sup_id;
    }

    public void setSup_id(int sup_id) {
        this.sup_id = sup_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", img_url='" + img_url + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                ", discout=" + discount +
                ", cus_id=" + cus_id +
                ", sup_id=" + sup_id +
                ", type_id=" + type_id +
                '}';
    }
}

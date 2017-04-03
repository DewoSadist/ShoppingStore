package ca.deos.store.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_options_item")
public class ProductOptionsItem {
    @Id
    @Column(name = "optd_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    double price;

    @Column(name = "opt_id")
    int opt_id;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOpt_id() {
        return opt_id;
    }

    public void setOpt_id(int opt_id) {
        this.opt_id = opt_id;
    }

    @Override
    public String toString() {
        return "ProductOptionsItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", opt_id=" + opt_id +
                '}';
    }
}

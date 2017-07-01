package ca.deos.store.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order_details")
public class OrderDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "prod_id")
    int employee_id;

    @Column(name = "unit_price")
    BigDecimal unit_price;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "note")
    String note;

    @Column(name ="additional")
    String additional;

    @Column(name = "title")
    String title;

//    @Column(name = "order_id")
//    String order_id;
//
    @ManyToOne
//    @JoinColumn(name = "order_id")
    Order order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote (String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

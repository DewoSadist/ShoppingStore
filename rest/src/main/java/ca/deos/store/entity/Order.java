package ca.deos.store.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "employee_id")
    int employee_id;

    @Column(name = "order_day")
    @JsonFormat(pattern = "yyyy-mm-dd")
    Date order_day;

    @Column(name = "order_time")
    Time order_time;

    @Column(name = "req_day")
    @JsonFormat(pattern = "yyyy-mm-dd")
    Date req_day;

    @Column(name = "req_time")
    Time req_time;

    @Column(name = "ship_via")
    String ship_via;

    @Column(name = "order_amount")
    int order_amount;

    @Column(name = "customer_id")
    int customer_id;

    @Column(name = "order_products")
    String order_products;

    @Column(name="user_id")
    String user_id;

    public String getUser_id() {
        return user_id;
    }

//    @OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true, mappedBy = "orders", fetch = FetchType.LAZY)
//    private List<OrderDetails> orderDetails;
//
//    public List<OrderDetails> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(List<OrderDetails> orderDetails) {
//        this.orderDetails = orderDetails;
//    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_products() {
        return order_products;
    }

    public void setOrder_products(String order_products) {
        this.order_products = order_products;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

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

    public Date getOrder_day() {
        return order_day;
    }

    public void setOrder_day(Date order_day) {
        this.order_day = order_day;
    }

    public Time getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Time order_time) {
        this.order_time = order_time;
    }

    public Date getReq_day() {
        return req_day;
    }

    public void setReq_day(Date req_day) {
        this.req_day = req_day;
    }

    public Time getReq_time() {
        return req_time;
    }

    public void setReq_time(Time req_time) {
        this.req_time = req_time;
    }

    public String getShip_via() {
        return ship_via;
    }

    public void setShip_via(String ship_via) {
        this.ship_via = ship_via;
    }

    public int getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }
}

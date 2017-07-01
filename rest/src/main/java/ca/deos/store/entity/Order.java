package ca.deos.store.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @Column(name = "res_id")
    int res_id;

    @Column(name = "res_name")
    String res_name;

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
    BigDecimal order_amount;

    @Column(name = "user_id")
    String user_id;

    @Column(name = "status")
    String status;

    @Column(name = "reorder")
    int reorder;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "tax")
    BigDecimal tax;

    @Column(name = "delivery")
    BigDecimal delivery;

    @Column(name = "service_fee")
    BigDecimal service_fee;

    @Column(name = "small_order_fee")
    BigDecimal small_order_fee;

    @Column(name = "client_name")
    String client_name;

    @Column(name = "client_address")
    String client_address;

    @Column(name = "client_number")
    String client_number;

    @Column(name = "client_email")
    String client_email;

    @Column(name = "payment")
    String payment;



    @OneToMany(cascade =  CascadeType.ALL )
    @JoinColumn(name = "order_order_id")
    private List<OrderDetails> orderDetails;

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }


    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReorder() {
        return reorder;
    }

    public void setReorder(int reorder) {
        this.reorder = reorder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public void setOrder_amount(BigDecimal order_amount) {
        this.order_amount = order_amount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getOrder_amount() {
        return order_amount;
    }

    public BigDecimal getDelivery() {
        return delivery;
    }

    public void setDelivery(BigDecimal delivery) {
        this.delivery = delivery;
    }

    public BigDecimal getService_fee() {
        return service_fee;
    }

    public void setService_fee(BigDecimal service_fee) {
        this.service_fee = service_fee;
    }

    public BigDecimal getSmall_order_fee() {
        return small_order_fee;
    }

    public void setSmall_order_fee(BigDecimal small_order_fee) {
        this.small_order_fee = small_order_fee;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getClient_number() {
        return client_number;
    }

    public void setClient_number(String client_number) {
        this.client_number = client_number;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", res_id=" + res_id +
                ", res_name='" + res_name + '\'' +
                ", order_day=" + order_day +
                ", order_time=" + order_time +
                ", req_day=" + req_day +
                ", req_time=" + req_time +
                ", ship_via='" + ship_via + '\'' +
                ", order_amount=" + order_amount +
                ", user_id='" + user_id + '\'' +
                ", status='" + status + '\'' +
                ", reorder=" + reorder +
                ", quantity=" + quantity +
                ", tax=" + tax +
                ", delivery=" + delivery +
                ", service_fee=" + service_fee +
                ", small_order_fee=" + small_order_fee +
                ", client_name='" + client_name + '\'' +
                ", client_address='" + client_address + '\'' +
                ", client_number='" + client_number + '\'' +
                ", client_email='" + client_email + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

}

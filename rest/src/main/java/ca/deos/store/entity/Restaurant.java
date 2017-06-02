package ca.deos.store.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant implements Serializable{

    public Restaurant(){

    }


    @Id
    @Column(name = "res_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "slug")
    private String slug;

    @Column(name = "tags")
    private String tags;

    @Column(name="description")
    private String description;

    @Column(name="logo_image_url")
    private String logo_image_url;

    @Column(name = "header_image_url")
    private String header_image_url;

    @Column(name = "cover_image_url")
    private String cover_image_url;

    @Column(name = "status")
    private String status;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "location")
    private String location;

    @Column(name = "fax")
    private String fax;

    @Column(name = "phone")
    private String phone;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "open_id")
    private int open_id;

    @Column(name = "ratings")
    private int ratings;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column (name = "delivery")
    private BigDecimal delivery;

    @Column (name = "service_fee")
    private BigDecimal service_fee;

    @Column(name = "small_order_fee")
    private BigDecimal small_order_fee;

//    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
//    private List<Category> categories;


    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", tags='" + tags + '\'' +
                ", description='" + description + '\'' +
                ", logo_image_url='" + logo_image_url + '\'' +
                ", header_image_url='" + header_image_url + '\'' +
                ", cover_image_url='" + cover_image_url + '\'' +
                ", status='" + status + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", fax='" + fax + '\'' +
                ", phone='" + phone + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", open_id=" + open_id +
                ", ratings=" + ratings +
                '}';
    }

//    @OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true, mappedBy = "restaurant")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_res_id")
    private List<Hour> hours;

    public List<Hour> getHours() {
        return hours;
    }

    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }

//    public List<Category> getCategories() {
//        return this.categories;
//    }

//    public void setCategories(List<Category> categories) {
//        this.categories = (List<Category>) categories;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo_image_url() {
        return logo_image_url;
    }

    public void setLogo_image_url(String logo_image_url) {
        this.logo_image_url = logo_image_url;
    }

    public String getHeader_image_url() {
        return header_image_url;
    }

    public void setHeader_image_url(String header_image_url) {
        this.header_image_url = header_image_url;
    }

    public String getCover_image_url() {
        return cover_image_url;
    }

    public void setCover_image_url(String cover_image_url) {
        this.cover_image_url = cover_image_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOpen_id() {
        return open_id;
    }

    public void setOpen_id(int open_id) {
        this.open_id = open_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
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
}

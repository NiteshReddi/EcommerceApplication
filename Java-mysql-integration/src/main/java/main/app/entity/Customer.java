package main.app.entity;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @Column(name = "created_date")
    private Date createdDate;

    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @Column(name = "updated_date")
    private Date updateDate;

    @Column(name = "is_prime_user")
    private Boolean isPrimeUser;

    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @Column(name = "prime_start_date")
    private Date primeStartDate;

    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @Column(name = "prime_end_date")
    private Date primeEndDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Orders> orders;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getPrimeUser() {
        return isPrimeUser;
    }

    public void setPrimeUser(Boolean primeUser) {
        isPrimeUser = primeUser;
    }

    public Date getPrimeStartDate() {
        return primeStartDate;
    }

    public void setPrimeStartDate(Date primeStartDate) {
        this.primeStartDate = primeStartDate;
    }

    public Date getPrimeEndDate() {
        return primeEndDate;
    }

    public void setPrimeEndDate(Date primeEndDate) {
        this.primeEndDate = primeEndDate;
    }
}
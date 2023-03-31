package main.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="customer_details")
public class CustomerDetailsForOrder {

    @Id
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name="customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "full_address")
    private String fullAddress;
}

package com.order.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "transcation_id")
    private Long transactionId;

    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "address_id")
    private Long addressId;

}

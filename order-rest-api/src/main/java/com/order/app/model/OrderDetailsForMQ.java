package com.order.app.model;


import lombok.Data;

@Data
public class OrderDetailsForMQ {
    private String customerName;

    private String fullAddress;

    private String productName;

    private Double price;

    private String paymentType;

    private Long orderId;

    private Long transactionId;

    private String customerEmail;
    public OrderDetailsForMQ(String customerName, String fullAddress,
                             String productName, Double price,
                             String paymentType, Long orderId, Long transactionId, String customerEmail) {
        this.customerName = customerName;
        this.fullAddress = fullAddress;
        this.productName = productName;
        this.price = price;
        this.paymentType = paymentType;
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.customerEmail = customerEmail;
    }
}

package com.order.app.model;

import lombok.Data;

@Data
public class NewOrderInfo {

    private String customerName;

    private String fullAddress;

    private String productName;

    private Double price;

    private String paymentType;
}

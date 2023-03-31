package com.order.app.model;

import lombok.Data;

@Data
public class Product {

    private Long productId;

    private String productName;

    private Double price;

    private int discount;

    private boolean isActiveProduct;

}
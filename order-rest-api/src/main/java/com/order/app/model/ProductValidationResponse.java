package com.order.app.model;

import lombok.Data;

@Data
public class ProductValidationResponse {

    private String errorMessage;

    private Long productId;
}

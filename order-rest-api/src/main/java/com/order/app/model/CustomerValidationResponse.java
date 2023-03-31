package com.order.app.model;

import lombok.Data;

@Data
public class CustomerValidationResponse {

    private String errorMessage;
    private Long customerId;
    private Long addressId;

    private String emailId;

}

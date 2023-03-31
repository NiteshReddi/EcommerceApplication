package com.order.app.model;

import lombok.Data;

@Data
public class PaymentValidationResponse {

    private Long paymentId;

    private String errorMessage;

}

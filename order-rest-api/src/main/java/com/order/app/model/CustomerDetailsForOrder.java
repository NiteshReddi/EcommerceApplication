package com.order.app.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class CustomerDetailsForOrder {

    private Long addressId;

    private Long customerId;

    private String customerName;

    private String customerEmail;

    private String fullAddress;
}

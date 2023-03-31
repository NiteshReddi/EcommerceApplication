package com.order.app.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="order_details")
public class OrderDetail {
	
	@Id
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="transcation_id")
	private Long transactionId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="full_address")
	private String fullAddress;
	
	@Column(name="payment_type")
	private String paymentType;
	
	@Column(name="description")
	private String orderStatus;

}

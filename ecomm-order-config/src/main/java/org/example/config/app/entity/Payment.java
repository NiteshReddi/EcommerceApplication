package org.example.config.app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id")
    private Long paymentId;

    @Column(name="payment_type")
    private String paymentType;
}

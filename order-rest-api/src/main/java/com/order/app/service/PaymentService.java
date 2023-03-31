package com.order.app.service;

import com.order.app.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Value("${application.payment.details.url}")
    private String paymentDetailsEndPoint;

    public Payment[] getAllPaymentDetails(){
        RestTemplate restTemplate= new RestTemplate();

        ResponseEntity<Payment[]> response = restTemplate.getForEntity(paymentDetailsEndPoint, Payment[].class);
        return response.getBody();

    }
}

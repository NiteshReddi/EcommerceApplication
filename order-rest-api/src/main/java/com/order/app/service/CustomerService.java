package com.order.app.service;

import com.order.app.model.CustomerDetailsForOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    @Value("${application.customer.details.url}")
    private String customerDetailsEndPoint;

    public CustomerDetailsForOrder[] getCustomerDetailsByName(String customerName){
        RestTemplate restTemplate= new RestTemplate();

        ResponseEntity<CustomerDetailsForOrder[]> response = restTemplate.getForEntity(customerDetailsEndPoint+customerName, CustomerDetailsForOrder[].class);
        return response.getBody();

    }
}

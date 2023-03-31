package com.order.app.service;

import com.order.app.model.CustomerDetailsForOrder;
import com.order.app.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @Value("${application.product.details.url}")
    private String productDetailsEndPoint;

    public Product[] getProductDetailsByName(String productName){
        RestTemplate restTemplate= new RestTemplate();

        ResponseEntity<Product[]> response = restTemplate.getForEntity(productDetailsEndPoint+productName, Product[].class);
        return response.getBody();

    }
}

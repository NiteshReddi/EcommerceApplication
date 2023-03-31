package org.example.config.app.controller;

import org.example.config.app.entity.Payment;
import org.example.config.app.entity.Status;
import org.example.config.app.repository.PaymentRepository;
import org.example.config.app.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/value/status")
    public List<Status> getStatusData(){
        return statusRepository.findAll();
    }

    @GetMapping("/value/payment")
    public List<Payment> getPaymentData(){
        return paymentRepository.findAll();
    }
}

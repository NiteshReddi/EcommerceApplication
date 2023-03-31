package org.example.email.app.controller;

import org.example.email.app.model.EmailTemplate;
import org.example.email.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailTemplate emailTemplate){
        return emailService.sendEmail(emailTemplate);
    }

    @PostMapping("/sendEmailWithAttachment")
    public String sendEmailWithAttachment(@RequestBody EmailTemplate emailTemplate){
        return emailService.sendMailWithAttachment(emailTemplate);
    }

}

package org.example.jms.controller;

import org.example.jms.config.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activemq")
public class SendMessageToMQ {

    @Autowired
    Sender sender;

    @PostMapping("/send")
    public String postMessageToMQ(@RequestBody String message){
        sender.send(message);
        return "Successfully posted message to MQ";
    }

}

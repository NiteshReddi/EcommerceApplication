package org.example.jms.receiver;

import org.springframework.jms.annotation.JmsListener;

public class MessageReceiver {

    @JmsListener(destination = "practice-test-message")
    public void receive(String message) {
        System.err.println("received message:\t" + message);
    }
}

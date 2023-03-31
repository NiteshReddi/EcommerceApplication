package org.example.email.app.jmslistener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.email.app.model.EmailTemplate;
import org.example.email.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
public class MessageReceiver {

    @Autowired
    EmailService emailService;

    @JmsListener(destination = "new-order-notification")
    public void receive(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode orderInfo = objectMapper.readTree(message);

        JsonNode orderIdJsonNode = orderInfo.get("orderId");
        long orderId = orderIdJsonNode.asLong();

        JsonNode transactionIdJsonNode = orderInfo.get("transactionId");
        long transactionId = transactionIdJsonNode.asLong();

        JsonNode priceJsonNode = orderInfo.get("price");
        Double price = priceJsonNode.asDouble();

        JsonNode paymentTypeJsonNode = orderInfo.get("paymentType");
        String paymentType = paymentTypeJsonNode.asText();

        JsonNode productNameJsonNode = orderInfo.get("productName");
        String productName = productNameJsonNode.asText();

        JsonNode fullAddressJsonNode = orderInfo.get("fullAddress");
        String fullAddress = fullAddressJsonNode.asText();

        JsonNode customerNameJsonNode = orderInfo.get("customerName");
        String customerName = customerNameJsonNode.asText();

        JsonNode customerEmailJsonNode = orderInfo.get("customerEmail");
        String customerEmail = customerEmailJsonNode.asText();

        String emailBody = "Hello " + customerName
                +"\nThank you for choosing E-comm App to place your order"
                +"\nHere are the Order Details"
                +"\n\nOrder ID:\t"+orderId
                +"\nProduct Name:\t"+productName
                +"\nPrice:\t"+price+" PaymentType as:"+paymentType
                +"\nTransaction ID :"+transactionId
                +"\nYour order will be shipped to:\t"+fullAddress
                +"\n\n\n"
                +"Thanks & Regards,"
                +"\nE-comm Team.";

        String subject ="Order "+orderId+" has been Initiated";
        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.setSubject(subject);
        emailTemplate.setEmailBody(emailBody);
        emailTemplate.setToAddress(customerEmail);
        emailService.sendEmail(emailTemplate);

        System.err.println("received message:\t" + message);
    }
}

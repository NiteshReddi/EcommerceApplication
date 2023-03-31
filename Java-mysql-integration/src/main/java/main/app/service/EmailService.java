package main.app.service;

import main.app.model.CustomerInformation;
import main.app.model.EmailTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
@Service
public class EmailService {

    @Value("${application.send.welcome.email}")
    private String sendEmailEndPoint;

    public String sendEmail(CustomerInformation customerInformation) {
        RestTemplate restTemplate = new RestTemplate();
        EmailTemplate emailTemplate = new EmailTemplate();

        String emailBody ="Hello, "+customerInformation.getCustomerName()+"\n"
                +"\n"
                +"Welcome to the E-comm App.\n"
                +"Enjoy Shopping..\n\n"
                +"Thanks & regards\n"
                +"E-comm Customer Support Team.";

        String subject = "Welcome...!";

        emailTemplate.setToAddress(customerInformation.getCustomerEmail());
        emailTemplate.setSubject(subject);
        emailTemplate.setEmailBody(emailBody);
        emailTemplate.setIsAttachmentRequired(false);

        ResponseEntity<String> response = restTemplate.postForEntity(sendEmailEndPoint, emailTemplate, String.class);
        return response.getBody();

    }

}

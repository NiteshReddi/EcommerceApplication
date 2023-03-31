package com.nitesh.promotions.mainapp.service;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nitesh.promotions.mainapp.model.EmailTemplate;
import com.nitesh.promotions.mainapp.model.Product;

@Service
public class PromoService {
	
	
	@Value("${application.getproducts.url}")
	private String getAllProductsURL;
	
	
	@Value("${application.file.server.path}")
	private String serverPath;
	
	@Value("${application.send.email.with.attachment.url}")
	private String sendEmailWithAttachmentEndPoint;
	
	@Value("${mail.to.address}")
	private String toAddress;
	
	
	public Product[] getAllProductsFromProductAPI() {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(getAllProductsURL, Product[].class);
		System.err.println(responseEntity.getBody().length);
		return responseEntity.getBody();
	}
	
	public String createProductsFile(Product[] productArray) {
		//String fileName = "C:/Users/Public/promoApp/products.txt";
		
		try {
		      FileWriter myWriter = new FileWriter("C:/Users/Public/promoApp/products.txt");
		     
		     for(Product product: productArray) {
		    	  myWriter.write(product.getProductName()+"\t"+product.getPrice()+"\n");
		    	 // System.out.println("Successfully wrote to the file.");
		      }  
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return "sop";
	}
	
	public String createProductCSVFile(Product[] productArray){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddhhmmss");
		String dateAsString = simpleDateFormat.format(new Date());
		String fileName = serverPath+"products_"+dateAsString+".csv";
		try {
		      FileWriter myWriter = new FileWriter(fileName);   
		      myWriter.write("Product Id"+","+"Product Name"+","+"Price"+","+"Discount"+"\n");
		     for(Product product: productArray) {
		    	  myWriter.write(product.getProductId()+","+product.getProductName()+","+product.getPrice()+","+product.getDiscount()+"\n");
		      }  
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return fileName;
	}
	
	public String sendEmailWithProductsDataInCSV(String fileName) {
		
		RestTemplate restTemplate = new RestTemplate();
		EmailTemplate emailTemplate = new EmailTemplate();
		
		String emailBody ="Hi, \n"
						+"\n"
						+"Please find the attachment File with Product Data in CSV."
						+"\n\n"
						+"Thanks & regards\n"
						+"E-comm Promo Team.";
		
		String subject = "Product Data:"+ new Date();
		
		emailTemplate.setToAddress(toAddress);
		emailTemplate.setSubject(subject);
		emailTemplate.setEmailBody(emailBody);
		emailTemplate.setIsAttachmentRequired(true);
		emailTemplate.setFilePath(fileName);
		
		ResponseEntity<String> response = restTemplate.postForEntity(sendEmailWithAttachmentEndPoint, emailTemplate, String.class);
		return response.getBody();
		
	}
	
}


package com.nitesh.promotions.mainapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitesh.promotions.mainapp.model.Product;
import com.nitesh.promotions.mainapp.model.PromoResponse;
import com.nitesh.promotions.mainapp.service.PromoService;

@RestController
@RequestMapping("/promo")
public class PromotionController {
	
	@Autowired PromoService promoService;

	@GetMapping("/createProductsFile")
	public PromoResponse createProductsFile() {
	Product[] productArray =	promoService.getAllProductsFromProductAPI();
	
	PromoResponse promoResponse = new PromoResponse();
	
		try {
			String fileName = promoService.createProductsFile(productArray);
			promoResponse.setFileName(fileName);
			promoResponse.setStatusCode(200);
			promoResponse.setStatusMessage("Product API Call is Successfull and File Created Successfully");
		}catch(Exception ex) {
			
			promoResponse.setStatusCode(500);
			promoResponse.setStatusMessage("createProductsFile API call is failed.");
		
		}
	
		return promoResponse;
	}
	
	
	@PostMapping("/sendProductDataInEmail")
	public PromoResponse sendProductDataInEmail(){
		PromoResponse promoResponse = new PromoResponse();
		Product[] productArray = promoService.getAllProductsFromProductAPI();
		String fileName = promoService.createProductCSVFile(productArray);
		String emailAPIResponse = promoService.sendEmailWithProductsDataInCSV(fileName);
		promoResponse.setFileName(fileName);
		promoResponse.setStatusCode(200);
		promoResponse.setStatusMessage(emailAPIResponse);
		return promoResponse;	
	}
	
	
	
	
	
}
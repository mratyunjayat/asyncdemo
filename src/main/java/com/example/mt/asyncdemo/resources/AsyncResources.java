package com.example.mt.asyncdemo.resources;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mt.asyncdemo.domain.Customer;
import com.example.mt.asyncdemo.domain.Product;
import com.example.mt.asyncdemo.services.AsyncService;

@RestController
public class AsyncResources {

	private static Logger logger = LoggerFactory.getLogger(AsyncResources.class);
	
	@Autowired
	private AsyncService asyncService;
	
	@GetMapping("/prodcutsandcustomers")
	public String getProductsAndCustomer() throws InterruptedException {
		
		logger.info("Inside getProductsAndCustomer Start......");
		
		CompletableFuture<List<Product>> products =  asyncService.getProducts();
		
		CompletableFuture<List<Customer>> customers =  asyncService.getCustomers();

		CompletableFuture.allOf(products, customers).join();
		
		logger.info("Products : " + products);
		
		logger.info("Customers :" + customers.toString());
		
		logger.info("Inside getProductsAndCustomer End...........");
		
		return "Successful Completion";
	}

}

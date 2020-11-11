package com.example.mt.asyncdemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.mt.asyncdemo.domain.Customer;
import com.example.mt.asyncdemo.domain.Product;


@Service
public class AsyncService {

	private static Logger logger = LoggerFactory.getLogger(AsyncService.class);
	
	static private List<Product> products = new ArrayList<Product>();
	static private List<Customer> customers = new ArrayList<Customer>();
	
	static {
		
		// Load products
		products.add(new Product(1, "PhoneXR", "Apple iPhone XR"));
		products.add(new Product(2, "PhoneXs", "Smaller version of xr"));
		products.add(new Product(3, "PhoneX", "New iphone X model"));
		
		//Load customers
		customers.add(new Customer(1, "Sri", "Junk Guy1"));
		customers.add(new Customer(2, "Sayan", "Junk Guy2"));
		customers.add(new Customer(3, "Thir", "Junk Guy3"));
		customers.add(new Customer(3, "MJ", "Biggest Junk Guy"));
	}
	
	@Async
	public CompletableFuture<List<Product>> getProducts() throws InterruptedException {
		
		logger.info("Inside getProducts method Start....");
		
		Thread.sleep(10000);
		// Make some Rest call here
		
		logger.info("Inside getProducts method End....");
		
		return CompletableFuture.completedFuture(products);
	}

	@Async
	public CompletableFuture<List<Customer>> getCustomers() throws InterruptedException {
		
		logger.info("Inside getCustomer method starts....");
		
		Thread.sleep(10000);
		
		logger.info("Inside getCustomer method End....");
		
		return CompletableFuture.completedFuture(customers);
	}
}

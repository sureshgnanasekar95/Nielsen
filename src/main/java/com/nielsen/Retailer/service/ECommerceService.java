package com.nielsen.Retailer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nielsen.Retailer.model.Ecommerce;



@Service
public interface ECommerceService {
	
	Ecommerce addmetadata(Ecommerce ecommerce);
	
	Optional<Ecommerce> FindProducts(String shopperId);
	
	List<Ecommerce> showAllShopper();
	
	default List<Ecommerce> showAll() {
		return null;
	}

}

package com.nielsen.Retailer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nielsen.Retailer.dao.ECommerceDao;
import com.nielsen.Retailer.model.Ecommerce;


@Component
public class EcommerceServiceImpl implements ECommerceService {
	
	@Autowired
	ECommerceDao dao;

	@Override
	public Ecommerce addmetadata(Ecommerce ecommerce) {
		
		return this.dao.save(ecommerce);
	}

	@Override
	public Optional<Ecommerce> FindProducts(String shopperId) {
		return Optional.ofNullable(dao.findByshopperId(shopperId));
	}

	@Override
	public List<Ecommerce> showAllShopper() {
		return dao.findAll();
	}
	
}

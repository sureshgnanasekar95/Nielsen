package com.nielsen.Retailer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nielsen.Retailer.model.Ecommerce;





@Repository
public interface ECommerceDao extends JpaRepository<Ecommerce, Integer>{
	
	//List<Ecommerce> findProducts(int shopperId);
	
	Ecommerce findByshopperId(String shopperId);

}

package com.nielsen.Retailer.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nielsen.Retailer.model.Ecommerce;
import com.nielsen.Retailer.service.ECommerceService;



@RestController
public class Controller {

	@Autowired
	private ECommerceService service;


	@GetMapping("/ShopperAll")
	public List<Ecommerce> showShopper()
	{
		return service.showAllShopper();
	}

	@GetMapping("/Shopper/{shopperId}")	
	public Optional<Ecommerce> showProducts(@PathVariable("shopperId") String shopperId)
	{
		Optional<Ecommerce> opt = service.FindProducts(shopperId);	
		if(opt.isEmpty())
			return Optional.ofNullable(new Ecommerce());
		else
			return service.FindProducts(shopperId);

	}

	@PostMapping(path="/AddMetaData")
	public Ecommerce addNewDataReq(@RequestBody String payload)
	{
		try
		{
			JSONObject json = new JSONObject(payload);
			Ecommerce eco =new Ecommerce();
			eco.setShopper_ID(json.get("shopperId").toString());
			eco.setCategory(json.get("Category").toString());
			Integer pLimit = 0;
			try
			{
				pLimit = Integer.valueOf(json.get("pLimit").toString());
			}
			catch(Exception ex)
			{
				pLimit = 10;
			}
			if(pLimit < 10)
			{
				throw new Exception("Limit should be above 10");
			}
			eco.setLimit(pLimit);
			eco.setBrand(json.get("Brand").toString());
			Optional<Ecommerce> opt = service.FindProducts(json.get("shopperId").toString());
			if(opt.isEmpty()) 
				return service.addmetadata(eco);	
			else 
				return new Ecommerce();
		}
		
		catch (Exception e) {
			return new Ecommerce();
		}
		

	}
}

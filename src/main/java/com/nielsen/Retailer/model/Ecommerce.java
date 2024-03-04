package com.nielsen.Retailer.model;



import org.springframework.beans.factory.annotation.Value;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Ecommerce")
public class Ecommerce {

	@Id
	@NotNull
	private String shopperId;
	
	@Nullable
	private String Category;
	
	@Nullable
	private String Brand;
	
	@Nullable
	@Size(min = 10, max = 100)
	private Integer pLimit;

	public String getShopper_ID() {
		return shopperId;
	}
	public void setShopper_ID(String shopper_ID) {
		shopperId = shopper_ID;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public Integer getLimit() {
		return pLimit;
	}
	public void setLimit(Integer limit) {
		pLimit = limit;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Ecommerce [shopperId=" + shopperId + ", Category=" + Category + ", Brand=" + Brand + ", Limit="
				+ pLimit + "]";
	}



}

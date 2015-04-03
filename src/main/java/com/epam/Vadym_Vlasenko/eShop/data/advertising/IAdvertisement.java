package com.epam.Vadym_Vlasenko.eShop.data.advertising;

import java.util.List;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;

public interface IAdvertisement {

	void add(Product product);
	
	List<Product> getContent();
	
}

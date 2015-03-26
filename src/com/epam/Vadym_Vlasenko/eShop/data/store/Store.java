package com.epam.Vadym_Vlasenko.eShop.data.store;

import java.io.Serializable;
import java.util.List;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;

public interface Store extends Serializable {

	void addProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product getProductById(int id);
	
}

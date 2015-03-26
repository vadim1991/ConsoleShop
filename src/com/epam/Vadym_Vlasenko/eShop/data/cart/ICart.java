package com.epam.Vadym_Vlasenko.eShop.data.cart;

import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;

public interface ICart {
	
	void clear();
	
	Map<Integer, Integer> getAll();

	void add(Product product, Integer amont);
	
}

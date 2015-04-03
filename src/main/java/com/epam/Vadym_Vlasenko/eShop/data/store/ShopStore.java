package com.epam.Vadym_Vlasenko.eShop.data.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;

public class ShopStore implements Store,Serializable {

	private Map<Integer, Product> products;

	public ShopStore() {
		products = new HashMap<>();
	}

	@Override
	public void addProduct(Product product) {
		products.put(product.getId(), product);
	}

	@Override
	public List<Product> getAllProducts() {
		return new ArrayList<>(products.values());
	}

	@Override
	public Product getProductById(int id) {
		return products.get(id);
	}

}

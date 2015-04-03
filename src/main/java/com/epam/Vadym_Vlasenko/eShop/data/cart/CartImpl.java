package com.epam.Vadym_Vlasenko.eShop.data.cart;

import java.util.HashMap;
import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;

public class CartImpl implements ICart {

	private Map<Integer, Integer> products;

	public CartImpl() {
		products = new HashMap<Integer, Integer>();
	}

	@Override
	public void add(Product product, Integer amont) {
		if (products.containsKey(product.getId())) {
			products.put(product.getId(), products.get(product.getId()) + amont);
		} else {
			products.put(product.getId(), amont);
		}

	}

	@Override
	public void clear() {
		products.clear();
	}

	@Override
	public Map<Integer, Integer> getAll() {
		return products;
	}

}

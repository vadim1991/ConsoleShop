package com.epam.Vadym_Vlasenko.eShop.data.advertising;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;

public class Advertisement implements IAdvertisement {

	private LinkedHashMap<Integer, Product> lastFive;

	public Advertisement() {
		lastFive = new LinkedHashMap<Integer, Product>() {
			@Override
			protected boolean removeEldestEntry(
					Map.Entry<Integer, Product> eldest) {
				return this.size() > 5;
			}
		};
	}

	@Override
	public void add(Product product) {
		lastFive.put(product.getId(), product);
	}

	@Override
	public List<Product> getContent() {
		List<Product> list = new ArrayList<>(lastFive.values());
		Collections.reverse(list);
		return list;
	}

}

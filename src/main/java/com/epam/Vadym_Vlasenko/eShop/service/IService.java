package com.epam.Vadym_Vlasenko.eShop.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.ui.localization.Localizator;
import com.epam.Vadym_Vlasenko.eShop.util.input.Inputer;

public interface IService {

	List<Product> getAllProduct();

	Product getProductById(int id);

	void addToCart(Product product, Integer amont);

	List<Product> getLastFiveProduct();

	void addNewProduct(Product product);

	void initStore(String fileName);

	Map<Integer, Integer> getCartContent();

	void makeOrder();

	int sumAllOrders();

	Map<Date, Order> getAllOrders();

	Order getNearestOrder(Date date);

	List<Order> getAllFromPeriod(Date min, Date max);

	void setInput(int input);

	Inputer getInput();

	void setLocalizator(Localizator localizator);

	Localizator getLocalizator();

	void exit();

}

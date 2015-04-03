package com.epam.Vadym_Vlasenko.eShop.data.ordersJournal;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;

public interface Journal {

	void add(Order order);

	Map<Date, Order> getAllOrders();

	Order getNearestOrder(Date date);

	List<Order> getAllFromPeriod(Date min, Date max);

}

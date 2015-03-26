package com.epam.Vadym_Vlasenko.eShop.data.ordersJournal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;

public class JournalImpl implements Journal {

	private TreeMap<Date, Order> orders;

	public JournalImpl() {
		orders = new TreeMap<>();
	}

	@Override
	public void add(Order order) {
		orders.put(order.getDate(), order);
	}

	@Override
	public Map<Date, Order> getAllOrders() {
		return orders;
	}

	@Override
	public Order getNearestOrder(Date date) {
		Date lower = orders.ceilingKey(date);
		Date higher = orders.floorKey(date);
		Order tempOrder = null;
		if (lower == null && higher != null) {
			tempOrder = orders.get(higher);
		}
		if (lower != null && higher == null) {
			tempOrder = orders.get(lower);
		}
		if (lower != null && higher != null) {
			int deltaLower = Math.abs((int) (date.getTime() - lower.getTime()));
			int deltaHigher = Math
					.abs((int) (date.getTime() - higher.getTime()));
			if (deltaLower > deltaHigher) {
				tempOrder = orders.get(higher);
			} else {
				tempOrder = orders.get(lower);
			}
		}
		return tempOrder;
	}

	@Override
	public List<Order> getAllFromPeriod(Date min, Date max) {
		Map<Date, Order> subOrder = orders.subMap(min, true, max, true);
		return new ArrayList<>(subOrder.values());
	}

}

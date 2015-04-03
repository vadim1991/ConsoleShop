package com.epam.Vadym_Vlasenko.eShop.entity;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {

	private Map<Integer, Integer> contentMap;

	private Date date;

	public Order(Map<Integer, Integer> contentMap) {
		this.contentMap = new HashMap<Integer, Integer>(contentMap);
		date = new Date();
	}

	public Map<Integer, Integer> getContent() {
		return Collections.unmodifiableMap(contentMap);
	}

	public Date getDate() {
		return date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o.getClass() != this.getClass()))
			return false;

		Order order = (Order) o;

		if (!contentMap.equals(order.contentMap))
			return false;
		if (!date.equals(order.date))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = contentMap.hashCode();
		result = 31 * result + date.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return contentMap + ", date: " + date;
	}

}

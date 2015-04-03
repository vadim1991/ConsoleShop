package com.epam.Vadym_Vlasenko.eShop.command;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.*;

import java.util.Date;
import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.IService;

public class ShowNearestOrdersCommand implements Command {

	@Override
	public void execute(IService service) {
		Date date = getDate("Enter the date on which to search");
		print("This is nearest order");
		Order order = service.getNearestOrder(date);
		if (order == null) {
			print("You haven`t orders");
		}
		Map<Integer, Integer> content = order.getContent();
		int index = 1;
		for (Map.Entry<Integer, Integer> entry : content.entrySet()) {
			Product p = service.getProductById(entry.getKey());
			print(index++ + " - " + p + ", amount = " + entry.getValue()
					+ ", date: " + entry.getKey());
		}
	}

}

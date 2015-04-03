package com.epam.Vadym_Vlasenko.eShop.command;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.getDate;
import static com.epam.Vadym_Vlasenko.eShop.util.Util.print;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.IService;

public class ShowPeriodDateCommand implements Command {

	@Override
	public void execute(IService service) {
		Date min = getDate("Enter min date");
		Date max = getDate("Enter max date");
		print("There are all orders from this period");
		Iterator<Order> it = service.getAllFromPeriod(min, max).iterator();
		int index = 0;
		while (it.hasNext()) {
			Order order = it.next();
			for (Map.Entry<Integer, Integer> entry : order.getContent()
					.entrySet()) {
				Product p = service.getProductById(entry.getKey());
				print(index++ + " - " + p + ", amount = " + entry.getValue()
						+ ", date: " + entry.getKey());
			}
		}
	}

}

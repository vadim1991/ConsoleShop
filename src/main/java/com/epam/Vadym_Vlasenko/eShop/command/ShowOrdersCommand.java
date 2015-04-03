package com.epam.Vadym_Vlasenko.eShop.command;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.print;

import java.util.Date;
import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.IService;

public class ShowOrdersCommand implements Command {

	@Override
	public void execute(IService service) {
		print("It's all made orders");
		int index = 1;
		for (Map.Entry<Date, Order> entry : service.getAllOrders().entrySet()) {
			for (Map.Entry<Integer, Integer> obj : entry.getValue()
					.getContent().entrySet()) {
				Product p = service.getProductById(obj.getKey());
				print(index++ + " - " + p + ", amount = " + obj.getValue()
						+ ", date: " + entry.getKey());
			}
		}
	}
}

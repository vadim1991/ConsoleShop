package com.epam.Vadym_Vlasenko.eShop.command;

import com.epam.Vadym_Vlasenko.eShop.service.IService;
import com.epam.Vadym_Vlasenko.eShop.util.Util;

public class MakeOrderCommand implements Command {

	@Override
	public void execute(IService service) {
		int sumOfOrders = service.sumAllOrders();
		service.makeOrder();
		Util.print("You place your order. The total amount of the order = "
				+ sumOfOrders);
	}

}

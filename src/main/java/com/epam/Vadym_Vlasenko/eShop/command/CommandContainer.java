package com.epam.Vadym_Vlasenko.eShop.command;

import java.util.HashMap;
import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.util.Util;

public class CommandContainer {

	private Map<String, Command> commands;

	public CommandContainer() {
		commands = new HashMap<String, Command>();
		init();
	}

	public Command getCommand(String commandText) {
		Command command = commands.get(commandText);
		if (command != null) {
			return command;
		}
		Util.printError("This command is not exists");
		return new HelpCommand();
	}

	private void init() {
		commands.put("help", new HelpCommand());
		commands.put("addProduct", new AddProductCommand());
		commands.put("showAll", new ShowProductsCommand());
		commands.put("showLast", new LastFiveProductCommand());
		commands.put("showCart", new ShowFromCartCommand());
		commands.put("add", new AddToCartCommand());
		commands.put("showOrders", new ShowOrdersCommand());
		commands.put("makeOrder", new MakeOrderCommand());
		commands.put("period", new ShowPeriodDateCommand());
		commands.put("nearest", new ShowNearestOrdersCommand());
	}

}

package com.epam.Vadym_Vlasenko.eShop.command;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.print;

import com.epam.Vadym_Vlasenko.eShop.service.IService;

public class HelpCommand implements Command {

	private static final String HELP = "show all commands";
	private static final String ADD_PRODUCT = "add new product to shop";
	private static final String SHOW_ALL = "show all products from shop";
	private static final String ADD_TO_CART = "add product to cart";
	private static final String SHOW_ORDERS = "show your order history";
	private static final String SHOW_LAST_FIVE = "Show the last five items added";
	private static final String MAKE_ORDER = "to order all products from the cart";
	private static final String SHOW_FROM_CART = "to order all products from the cart";
	private static final String SHOW_FROM_PERIOD = "to show all orders from this period";
	private static final String SHOW_NEAREST = "to show nearest order";

	private static final String[] DESCRIPTION_COMMANDS = { HELP, ADD_PRODUCT,
			SHOW_ALL, ADD_TO_CART, SHOW_ORDERS, SHOW_LAST_FIVE, MAKE_ORDER,
			SHOW_FROM_CART, SHOW_FROM_PERIOD, SHOW_NEAREST };

	private static final String[] COMMANDS = { "help", "addProduct", "showAll",
			"add", "showOrders", "showLast", "makeOrder", "showCart", "period", "nearest" };

	@Override
	public void execute(IService service) {
		print("This commands to manage the store:");
		for (int i = 0; i < COMMANDS.length; i++) {
			print("**********");
			print(COMMANDS[i] + " --- " + DESCRIPTION_COMMANDS[i]);
		}
	}

}

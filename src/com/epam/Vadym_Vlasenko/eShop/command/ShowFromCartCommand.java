package com.epam.Vadym_Vlasenko.eShop.command;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.print;

import java.util.Map;

import com.epam.Vadym_Vlasenko.eShop.service.IService;

public class ShowFromCartCommand implements Command {

	private Map<Integer, Integer> content;

	public ShowFromCartCommand() {

	}

	@Override
	public void execute(IService service) {
		print("These are your cart");
		content = service.getCartContent();
		for (Map.Entry<Integer, Integer> entry : content.entrySet()) {
			print(service.getProductById(entry.getKey()) + ", amount = "
					+ entry.getValue());
		}
	}

}

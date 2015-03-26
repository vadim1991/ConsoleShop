package com.epam.Vadym_Vlasenko.eShop.command;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.enterInt;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.IService;

public class AddToCartCommand implements Command {

	private Product product;

	@Override
	public void execute(IService service) {
		int id = enterInt("Enter ID product");
		product = service.getProductById(id);
		int amount = enterInt("Enter amount of product, which you want to add to a cart:");
		service.addToCart(product, amount);
		System.out.println("Product has been added to a cart.");
	}
}

package com.epam.Vadym_Vlasenko.eShop.command;

import java.util.Iterator;
import java.util.List;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.IService;

public class ShowProductsCommand implements Command {

	@Override
	public void execute(IService service) {
		List<Product> products = service.getAllProduct();
		Iterator<Product> it = products.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

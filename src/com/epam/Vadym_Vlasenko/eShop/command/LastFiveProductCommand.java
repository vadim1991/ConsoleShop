package com.epam.Vadym_Vlasenko.eShop.command;

import java.util.Iterator;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.IService;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.print;

public class LastFiveProductCommand implements Command {

	@Override
	public void execute(IService service) {
		print("This last five ordered products");
		Iterator<Product> it = service.getLastFiveProduct().iterator();
		while (it.hasNext()) {
			print(it.next().toString());
		}
	}

}

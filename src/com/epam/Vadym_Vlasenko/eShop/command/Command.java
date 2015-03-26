package com.epam.Vadym_Vlasenko.eShop.command;

import com.epam.Vadym_Vlasenko.eShop.service.IService;

public interface Command {

	void execute(IService service);

}

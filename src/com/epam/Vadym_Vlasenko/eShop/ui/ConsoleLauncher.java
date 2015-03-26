package com.epam.Vadym_Vlasenko.eShop.ui;

import java.util.Scanner;

import com.epam.Vadym_Vlasenko.eShop.command.Command;
import com.epam.Vadym_Vlasenko.eShop.command.CommandContainer;
import com.epam.Vadym_Vlasenko.eShop.service.IService;
import com.epam.Vadym_Vlasenko.eShop.service.Service;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.*;

public class ConsoleLauncher implements Launcher {

	private IService service;

	private Scanner scanner = new Scanner(System.in);

	public ConsoleLauncher() {
		service = new Service();
	}

	@Override
	public void start() {
		String fileName = "src/store.txt";
		service.initStore(fileName);
		print("Welcome to eShop");
		print("Enter the method of adding products");
		print("1  -  Console");
		print("2  -   Random");
		int typeInput = enterInt("");
		print("Thank you. You made your choice");
		print("Use 'help' the command view");
		service.setInput(typeInput);
		while (scanner.hasNext()) {
			String commandText = scanner.nextLine();
			if ("exit".equalsIgnoreCase(commandText)) {
				service.exit();
			}
			Command command = new CommandContainer().getCommand(commandText);
			command.execute(service);
		}

	}

}

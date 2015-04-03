package com.epam.Vadym_Vlasenko.eShop.ui;

import java.util.Scanner;

import com.epam.Vadym_Vlasenko.eShop.command.Command;
import com.epam.Vadym_Vlasenko.eShop.command.CommandContainer;
import com.epam.Vadym_Vlasenko.eShop.servers.HttpServerRunner;
import com.epam.Vadym_Vlasenko.eShop.servers.TcpServersRunner;
import com.epam.Vadym_Vlasenko.eShop.service.IService;
import com.epam.Vadym_Vlasenko.eShop.service.Service;
import com.epam.Vadym_Vlasenko.eShop.ui.localization.Localizator;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.*;

public class ConsoleLauncher implements Launcher {

    private IService service;

    private Scanner scanner = new Scanner(System.in);

    public ConsoleLauncher() {
        service = new Service();
    }

    @Override
    public void start() {
        String fileName = "src\\main\\resources\\store.txt";
        service.initStore(fileName);
        TcpServersRunner tcpServerRunner = new TcpServersRunner(service);
        HttpServerRunner httpServerRunner = new HttpServerRunner(service);
        new Thread(tcpServerRunner).start();
        new Thread(httpServerRunner).start();
        print("Welcome to eShop");
        print("Enter the method of adding products");
        print("1  -  Console");
        print("2  -   Random");
        int typeInput = getInt("");
        print("Enter the language");
        print("EN  - English ");
        print("RU  -   Russian");
        String language = getString("");
        Localizator localizator = new Localizator();
        localizator.setup(language);
        service.setLocalizator(localizator);
        print("Thank you. You made your choice");
        print("Use 'help' the command view");
        service.setInput(typeInput);
        CommandContainer container = new CommandContainer();
        while (scanner.hasNext()) {
            String commandText = scanner.nextLine();
            if ("exit".equalsIgnoreCase(commandText)) {
                service.exit();
            }
            Command command = container.getCommand(commandText);
            command.execute(service);
        }
    }

}

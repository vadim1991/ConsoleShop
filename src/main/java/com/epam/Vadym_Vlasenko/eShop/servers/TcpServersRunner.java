package com.epam.Vadym_Vlasenko.eShop.servers;

import com.epam.Vadym_Vlasenko.eShop.servers.factory.AbstractFactory;
import com.epam.Vadym_Vlasenko.eShop.servers.factory.HttpShopFactory;
import com.epam.Vadym_Vlasenko.eShop.servers.factory.TcpShopFactory;
import com.epam.Vadym_Vlasenko.eShop.servers.http_server.HttpServer;
import com.epam.Vadym_Vlasenko.eShop.servers.server.Server;
import com.epam.Vadym_Vlasenko.eShop.servers.shop.ShopInfo;
import com.epam.Vadym_Vlasenko.eShop.servers.tcp_server.TcpServer;
import com.epam.Vadym_Vlasenko.eShop.service.IService;

/**
 * Created by Вадим on 02.04.2015.
 */
public class TcpServersRunner implements Runnable {

    private IService service;

    public TcpServersRunner(IService service) {
        this.service = service;
    }

    @Override
    public void run() {
        ShopInfo shopInfo = new ShopInfo(service);
        AbstractFactory tcpFactory = new TcpShopFactory(shopInfo);
//        TcpServer tcpServer = new TcpServer(tcpFactory);
//        tcpServer.start();
        Server server = new Server(tcpFactory, Constants.PORT_TCP);
        server.start();
    }
}

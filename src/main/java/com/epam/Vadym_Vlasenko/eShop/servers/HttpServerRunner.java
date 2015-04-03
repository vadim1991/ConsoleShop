package com.epam.Vadym_Vlasenko.eShop.servers;

import com.epam.Vadym_Vlasenko.eShop.servers.factory.AbstractFactory;
import com.epam.Vadym_Vlasenko.eShop.servers.factory.HttpShopFactory;
import com.epam.Vadym_Vlasenko.eShop.servers.server.Server;
import com.epam.Vadym_Vlasenko.eShop.servers.shop.ShopInfo;
import com.epam.Vadym_Vlasenko.eShop.service.IService;

/**
 * Created by Vadym_Vlasenko on 03.04.2015.
 */
public class HttpServerRunner implements Runnable {

    private IService service;

    public HttpServerRunner(IService service) {
        this.service = service;
    }

    @Override
    public void run() {
        ShopInfo shopInfo = new ShopInfo(service);
        AbstractFactory httpFactory = new HttpShopFactory(shopInfo);
//        HttpServer httpServer = new HttpServer(httpFactory);
//        httpServer.start();
        Server server = new Server(httpFactory,Constants.PORT_HTTP);
        server.start();

    }
}

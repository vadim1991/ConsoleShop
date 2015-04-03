package com.epam.Vadym_Vlasenko.eShop.servers.http_server;

/**
 * Created by Vadym_Vlasenko on 02.04.2015.
 */

import com.epam.Vadym_Vlasenko.eShop.servers.Constants;
import com.epam.Vadym_Vlasenko.eShop.servers.factory.AbstractFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yar 09.09.2009
 */
public class HttpServer {

    private AbstractFactory factory;

    public HttpServer(AbstractFactory factory) {
        this.factory = factory;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(Constants.PORT_HTTP);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new SocketProcessor(socket)).start();
            }
        } catch (IOException e) {
        }
    }

    private class SocketProcessor implements Runnable {

        private Socket socket;

        public SocketProcessor(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            factory.work(socket);
        }
    }

}

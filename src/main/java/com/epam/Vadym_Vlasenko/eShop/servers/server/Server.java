package com.epam.Vadym_Vlasenko.eShop.servers.server;

import com.epam.Vadym_Vlasenko.eShop.servers.factory.AbstractFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vadym_Vlasenko on 03.04.2015.
 */
public class Server {

    private AbstractFactory factory;
    private int port;

    public Server(AbstractFactory factory, int port) {
        this.factory = factory;
        this.port = port;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ServerProcess(socket)).start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private class ServerProcess implements Runnable {
        private Socket socket;

        public ServerProcess(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            factory.work(socket);
        }
    }

}

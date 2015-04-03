package com.epam.Vadym_Vlasenko.eShop.servers.tcp_server;

import com.epam.Vadym_Vlasenko.eShop.servers.Constants;
import com.epam.Vadym_Vlasenko.eShop.servers.factory.AbstractFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vadym_Vlasenko on 02.04.2015.
 */
public class TcpServer {

    private AbstractFactory factory;

    public TcpServer(AbstractFactory factory) {
        this.factory = factory;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(Constants.PORT_TCP);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new SocketProcess(socket)).start();
            }
        } catch (IOException e) {

        }

    }

    private class SocketProcess implements Runnable {

        private Socket socket;

        private SocketProcess(Socket socket) throws IOException {
            this.socket = socket;
        }

        @Override
        public void run() {
            factory.work(socket);
        }
    }

}

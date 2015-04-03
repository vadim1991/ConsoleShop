package com.epam.Vadym_Vlasenko.eShop.servers;

import com.epam.Vadym_Vlasenko.eShop.servers.factory.TcpShopFactory;
import com.epam.Vadym_Vlasenko.eShop.servers.shop.ShopInfo;
import com.epam.Vadym_Vlasenko.eShop.servers.tcp_server.TcpServer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.*;
import java.net.Socket;

import static org.mockito.Mockito.*;

/**
 * Created by Vadym_Vlasenko on 03.04.2015.
 */
public class TcpServerTest {

    TcpServer server;
    TcpServer serverSpy;
    ShopInfo shopInfo;

    @Before
    public void init() {
        shopInfo = mock(ShopInfo.class);
        server = new TcpServer(new TcpShopFactory(shopInfo));
        serverSpy = Mockito.spy(server);
    }

    @Test
    public void testCountCommand() {
        int result = 5;
        when(shopInfo.count()).thenReturn(result);

        Thread serThread = new Thread(new Runnable() {
            @Override
            public void run() {
                server.start();
            }
        });
        serThread.start();

        Thread clientThread = new Thread(new Runnable() {
            Socket socket;
            BufferedWriter bufferedWriter;
            BufferedReader bufferedReader;

            @Override
            public void run() {
                try {
                    socket = new Socket(Constants.LOCALHOST, Constants.PORT_TCP);
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    bufferedWriter.write(Constants.COUNT_COMMAND);
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bufferedWriter.close();
                        bufferedReader.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        clientThread.start();
        verify(shopInfo);
    }

    @Test
    public void testGetItem() {
       String result = "Ring|4400";
        String type = "our";
        final String command = Constants.ITEM_COMMAND + "=1";
        when(shopInfo.getProductById(1,Constants.OUR_TYPE)).thenReturn(result, type);

        Thread serThread = new Thread(new Runnable() {
            @Override
            public void run() {
                server.start();
            }
        });
        serThread.start();

        Thread clientThread = new Thread(new Runnable() {
            Socket socket;
            BufferedWriter bufferedWriter;
            BufferedReader bufferedReader;

            @Override
            public void run() {
                try {
                    System.out.println("hello");
                    socket = new Socket(Constants.LOCALHOST, Constants.PORT_TCP);
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    bufferedWriter.write(command);
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bufferedWriter.close();
                        bufferedReader.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        clientThread.start();
        verify(shopInfo);
    }


}


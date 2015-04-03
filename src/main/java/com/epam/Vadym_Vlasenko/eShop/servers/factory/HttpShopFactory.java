package com.epam.Vadym_Vlasenko.eShop.servers.factory;

import com.epam.Vadym_Vlasenko.eShop.servers.Constants;
import com.epam.Vadym_Vlasenko.eShop.servers.shop.ShopInfo;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Vadym_Vlasenko on 03.04.2015.
 */
public class HttpShopFactory extends AbstractFactory {

    private ShopInfo shopInfo;

    public HttpShopFactory(ShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    @Override
    public void work(Socket socket) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            String request = bufferedReader.readLine();
            String url = getUrl(request);
            String[] parseRequest;
            String command;
            String id = null;
            if (url.contains("=")) {
                parseRequest = url.split("=");
                command = parseRequest[0].trim();
                id = parseRequest[1].trim();
            } else {
                command = url.trim();
            }
            executeCommand(command, id, bufferedWriter);
        } catch (IOException e) {

        }
    }

    private void executeCommand(String command, String id, BufferedWriter bufferedWriter) throws IOException {
        try {
            if (Constants.HTTP_COUNT_COMMAND.equals(command)) {
                bufferedWriter.write("{count=\"" + shopInfo.count() + "\"}");
                bufferedWriter.flush();
            } else if (Constants.HTTP_ITEM_COMMAND.equals(command)) {
                bufferedWriter.write(createPositiveHeader() + shopInfo.getProductById(Integer.parseInt(id), Constants.HTTP_TYPE));
                bufferedWriter.flush();
            } else {
                bufferedWriter.write(createNegativeHeader() + "404 Not Found");
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            bufferedWriter.write(Constants.ERROR);
            System.err.println(e);
        }

    }

    private String createPositiveHeader() {
        String response =
                "HTTP/1.1 200 OK\r\n" +
                        "Server: MyTCPServer/" + new Date().toString() + "\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length:\r\n" +
                        "Connection: close\r\n\r\n";
        return response;
    }

    private String createNegativeHeader() {
        String response =
                "HTTP/1.1 404 NOT FOUND\r\n" +
                        "Server: MyTCPServer/" + new Date().toString() + "\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length:\r\n" +
                        "Connection: close\r\n\r\n";
        return response;
    }

    private String getUrl(String request) {
        String result = "";
        if (request != null) {
            String[] path = request.split(" ");
            result = path[1];
        }
        return result;
    }

}

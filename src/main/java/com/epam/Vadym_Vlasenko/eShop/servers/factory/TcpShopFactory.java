package com.epam.Vadym_Vlasenko.eShop.servers.factory;

import com.epam.Vadym_Vlasenko.eShop.entity.Jewel;
import com.epam.Vadym_Vlasenko.eShop.servers.Constants;
import com.epam.Vadym_Vlasenko.eShop.servers.shop.ShopInfo;

import java.io.*;
import java.net.Socket;

/**
 * Created by Вадим on 02.04.2015.
 */
public class TcpShopFactory extends AbstractFactory {

    private ShopInfo shopInfo;

    public TcpShopFactory(ShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    @Override
    public void work(Socket socket) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            String request = bufferedReader.readLine();
            String[] parseRequest;
            String command;
            String id = null;
            if (request.contains("=")) {
                parseRequest = request.split("=");
                command = parseRequest[0].trim();
                id = parseRequest[1].trim();
            } else {
                command = request.trim();
            }
            executeCommand(command, id, bufferedWriter);
        } catch (IOException e) {

        }
    }

    private void executeCommand(String command, String id, BufferedWriter bufferedWriter) throws IOException {
        if (Constants.COUNT_COMMAND.equals(command)) {
            bufferedWriter.write("count = " + shopInfo.count());
            bufferedWriter.flush();
        } else if (Constants.ITEM_COMMAND.equals(command)) {
            bufferedWriter.write(shopInfo.getProductById(Integer.parseInt(id), Constants.OUR_TYPE));
            bufferedWriter.flush();
        } else {
            bufferedWriter.write(Constants.ERROR);
            bufferedWriter.flush();
        }
    }

}

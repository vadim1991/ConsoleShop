package com.epam.Vadym_Vlasenko.eShop.servers.client;

import com.epam.Vadym_Vlasenko.eShop.servers.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        while (true) {
            try (Socket socket = new Socket(Constants.LOCALHOST, Constants.PORT_TCP);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextLine()) {
                    out.write(scanner.nextLine());
                }
                out.newLine();
                out.flush();
                System.out.println(in.readLine());
            } catch (Exception e) {
                System.out.println("Error with connection");
            }
        }
    }

}

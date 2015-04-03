package com.epam.Vadym_Vlasenko.eShop.servers.factory;

/**
 * Created by Vadym_Vlasenko on 02.04.2015.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yar 09.09.2009
 */
public class HttpServerRRR {

    public static void main(String[] args) throws Throwable {
        ServerSocket ss = new ServerSocket(3800);
        while (true) {
            Socket s = ss.accept();
            System.err.println("Client accepted");
            new Thread(new SocketProcessor(s)).start();
        }
    }

    private static class SocketProcessor implements Runnable {

        private Socket s;
        private InputStream is;
        private OutputStream os;

        private SocketProcessor(Socket s) throws Throwable {
            this.s = s;
            this.is = s.getInputStream();
            this.os = s.getOutputStream();
        }

        public void run() {
            try {
                readInputHeaders();
                writeResponse("<html><body><h1>This my JewelryShop</h1></body></html>");
            } catch (Throwable t) {
                /*do nothing*/
            } finally {
                try {
                    s.close();
                } catch (Throwable t) {
                    /*do nothing*/
                }
            }
            System.err.println("Client processing finished");
        }

        private void writeResponse(String s) throws Throwable {
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Server: YarServer/2009-09-09\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + s.length() + "\r\n" +
                    "Connection: close\r\n\r\n";
            String result = response + s;
            os.write(result.getBytes());
            os.flush();
        }

        private void readInputHeaders() throws Throwable {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s = br.readLine();
            System.out.println(s);
        }

        protected String getPath(String header) {
            // ищем URI, указанный в HTTP запросе
            // URI ищется только для методов POST и GET, иначе возвращается null
            String URI = extract(header, "GET ", " "), path;

            if (URI == null) URI = extract(header, "POST ", " ");
            if (URI == null) return null;

            // если URI записан вместе с именем протокола
            // то удаляем протокол и имя хоста
            path = URI.toLowerCase();
            if (path.indexOf("http://", 0) == 0) {
                URI = URI.substring(7);
                URI = URI.substring(URI.indexOf("/", 0));
            } else if (path.indexOf("/", 0) == 0)
                URI = URI.substring(1); // если URI начинается с символа /, удаляем его

            // отсекаем из URI часть запроса, идущего после символов ? и #
            int i = URI.indexOf("?");
            if (i > 0) URI = URI.substring(0, i);
            i = URI.indexOf("#");
            if (i > 0) URI = URI.substring(0, i);

            // конвертируем URI в путь до документов
            // предполагается, что документы лежат там же, где и сервер
            // иначе ниже нужно переопределить path
            path = "." + File.separator;
            char a;
            for (i = 0; i < URI.length(); i++) {
                a = URI.charAt(i);
                if (a == '/')
                    path = path + File.separator;
                else
                    path = path + a;
            }

            return path;
        }

        protected String extract(String str, String start, String end) {
            int s = str.indexOf("\n\n", 0), e;
            if (s < 0) s = str.indexOf("\r\n\r\n", 0);
            if (s > 0) str = str.substring(0, s);
            s = str.indexOf(start, 0) + start.length();
            if (s < start.length()) return null;
            e = str.indexOf(end, s);
            if (e < 0) e = str.length();
            return (str.substring(s, e)).trim();
        }
    }

}

package com.webserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            // İsteğin ilk satırını oku (HTTP Request line)
            String requestLine = in.readLine();
            if (requestLine != null) {
                System.out.println("Gelen İstek: " + requestLine);
            }

            // HTML İçeriğini al (Ad Soyad ve Öğrenci No ödev yönergesine tam uygun)
            String htmlBody = HttpResponse.getHtmlContent("Gülcan Yaman", "1250505076");

            // HTTP Yanıt Başlıkları (Response Headers)
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html; charset=UTF-8");
            out.println("Content-Length: " + htmlBody.getBytes("UTF-8").length);
            out.println("Connection: close");
            out.println(); // Başlıklar ile gövde arasında boş satır olmalı

            // HTML Gövdesini tarayıcıya gönder
            out.println(htmlBody);

        } catch (Exception e) {
            System.err.println("İstemci işlenirken hata oluştu: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (Exception e) {
                // Kapatma hatası yoksayılabilir
            }
        }
    }
}

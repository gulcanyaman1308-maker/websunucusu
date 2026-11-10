package com.webserver;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private static final int PORT = 1989;

    public static void main(String[] args) {
        System.out.println("Web sunucusu başlatılıyor...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Sunucu başarıyla başlatıldı ve " + PORT + " portunda dinliyor...");
            System.out.println("Tarayıcınızdan şu adrese gidebilirsiniz: http://localhost:1989");

            while (true) {
                // Tarayıcıdan gelen bağlantı bekleniyor
                Socket clientSocket = serverSocket.accept();
                System.out.println("Yeni bir istemci bağlandı: " + clientSocket.getInetAddress());

                // Her istemciyi ayrı bir iş parçacığında (Thread) çalıştırıyoruz
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
            System.err.println("Sunucu hatası: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

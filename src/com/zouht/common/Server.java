package com.zouht.common;

import java.net.*;
import java.io.*;


public class Server {
    private final ServerSocket serverSocket;
    private int threatCount = 1;

    public Server() throws IOException {
        serverSocket = new ServerSocket(12233);
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket, threatCount);
                serverThread.run();
                threatCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }

    class ServerThread extends Thread {
        private final Socket socket;

        public ServerThread(Socket s, int c) throws IOException {
            socket = s;
            System.out.println("线程" + c + "启动成功");
        }

        public void run() {
            try {
                System.out.println("等待客户端连接中，端口号：" + serverSocket.getLocalPort());
                System.out.println("客户端已连接，地址：" + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println("收到客户端消息：" + in.readUTF());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String send = "我是服务端";
                System.out.println("发送客户端消息：" + send);
                out.writeUTF(send);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

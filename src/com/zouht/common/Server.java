package com.zouht.common;

import java.net.*;
import java.io.*;
import java.rmi.ServerError;

public class Server {
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("等待客户端连接中，端口号：" + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                System.out.println("客户端已连接，地址：" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println("收到客户端消息：" + in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                String send = "我是服务端";
                System.out.println("发送客户端消息：" + send);
                out.writeUTF(send);
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int serverPort = 12233;
        try {
            Server server = new Server(serverPort);
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

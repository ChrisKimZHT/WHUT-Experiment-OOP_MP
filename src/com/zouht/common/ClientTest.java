package com.zouht.common;

import java.net.*;
import java.io.*;

public class ClientTest {
    public static void main(String[] args) {
        String serverName = "localhost";
        int serverPort = 12233;
        try {
            System.out.println("连接服务端：" + serverName + ":" + serverPort);
            Socket client = new Socket(serverName, serverPort);
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            String send = "我是客户端";
            System.out.println("发送服务端消息：" + send);
            out.writeUTF(send);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("收到服务端消息：" + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
